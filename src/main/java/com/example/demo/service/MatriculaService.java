package com.example.demo.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.bean.dto.CursoDisponibilidadDTO;
import com.example.demo.bean.dto.MatriculaResponseDTO;
import com.example.demo.bean.entity.DetalleMatricula;
import com.example.demo.bean.entity.Matricula;
import com.example.demo.bean.enums.EstadoCurso;
import com.example.demo.bean.enums.EstadoMatricula;
import com.example.demo.bean.mapper.MatriculaMapper;
import com.example.demo.client.CursoClient;
import com.example.demo.repository.MatriculaRepository;
import com.example.demo.useCase.ObtenerMatriculaUseCase;
import com.example.demo.useCase.ValidarYConfirmarMatriculaUseCase;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MatriculaService implements ObtenerMatriculaUseCase, ValidarYConfirmarMatriculaUseCase {

    private final MatriculaRepository matriculaRepository;
    private final CursoClient cursoClient;
    private final MatriculaMapper mapper;

    @Override
    @Transactional(readOnly = true)
    public MatriculaResponseDTO obtener(Long idMatricula) {
        return mapper.toResponseDto(buscar(idMatricula));
    }

    @Override
    @Transactional
    public MatriculaResponseDTO validarYConfirmar(Long idMatricula) {
        Matricula matricula = buscar(idMatricula);

        boolean todosDisponibles = true;
        for (DetalleMatricula detalle : matricula.getDetalles()) {
            CursoDisponibilidadDTO curso = cursoClient.obtenerCurso(detalle.getIdCurso());
            boolean disponible = curso.getVacantesDisponibles() != null
                    && curso.getVacantesDisponibles() > 0
                    && EstadoCurso.ABIERTO.name().equals(curso.getEstadoCurso());
            if (!disponible) {
                todosDisponibles = false;
                break;
            }
        }

        matricula.setEstadoMatricula(todosDisponibles
                ? EstadoMatricula.CONFIRMADA
                : EstadoMatricula.RECHAZADA_SIN_VACANTES);

        return mapper.toResponseDto(matriculaRepository.save(matricula));
    }

    private Matricula buscar(Long idMatricula) {
        return matriculaRepository.findWithDetallesById(idMatricula)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Matrícula no encontrada: " + idMatricula));
    }
}