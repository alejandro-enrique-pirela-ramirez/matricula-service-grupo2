package com.example.demo.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.bean.dto.CursoDisponibilidadDTO;
import com.example.demo.bean.dto.MatriculaResponseDTO;
import com.example.demo.bean.dto.ResumenFichaEstudianteDTO;
import com.example.demo.bean.entity.Estudiante;
import com.example.demo.bean.enums.SituacionAcademica;
import com.example.demo.bean.mapper.MatriculaMapper;
import com.example.demo.client.CursoClient;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.MatriculaRepository;
import com.example.demo.useCase.ObtenerFichaEstudianteUseCase;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FichaEstudianteService implements ObtenerFichaEstudianteUseCase {

    private static final double PROMEDIO_MINIMO_REGULAR = 11.0;

    private final EstudianteRepository estudianteRepository;
    private final MatriculaRepository matriculaRepository;
    private final CursoClient cursoClient;
    private final MatriculaMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public ResumenFichaEstudianteDTO obtenerFicha(Long estudianteId) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Estudiante no encontrado: " + estudianteId));

        List<MatriculaResponseDTO> historial = matriculaRepository.findByEstudianteId(estudianteId)
                .stream()
                .map(mapper::toResponseDto)
                .toList();

        List<CursoDisponibilidadDTO> catalogo = cursoClient.listarPorEstudiante(estudianteId);

        SituacionAcademica situacion = estudiante.getPromedioPonderado() >= PROMEDIO_MINIMO_REGULAR
                ? SituacionAcademica.REGULAR
                : SituacionAcademica.OBSERVADO;

        return ResumenFichaEstudianteDTO.builder()
                .estudianteId(estudiante.getId())
                .nombreEstudiante(estudiante.getNombre())
                .carrera(estudiante.getCarrera())
                .sede(estudiante.getSede())
                .totalMatriculasRealizadas(historial.size())
                .promedioPonderadoAcumulado(estudiante.getPromedioPonderado())
                .historialMatriculas(historial)
                .catalogoCursosElegibles(catalogo)
                .situacionAcademica(situacion.name())
                .build();
    }
}