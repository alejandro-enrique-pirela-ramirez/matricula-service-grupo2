package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.dto.MatriculaResponseDTO;
import com.example.demo.bean.dto.ResumenFichaEstudianteDTO;
import com.example.demo.useCase.ObtenerFichaEstudianteUseCase;
import com.example.demo.useCase.ObtenerMatriculaUseCase;
import com.example.demo.useCase.ValidarYConfirmarMatriculaUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    private final ObtenerMatriculaUseCase obtenerMatriculaUseCase;
    private final ValidarYConfirmarMatriculaUseCase validarYConfirmarMatriculaUseCase;
    private final ObtenerFichaEstudianteUseCase obtenerFichaEstudianteUseCase;

    @GetMapping("/{idMatricula}")
    public MatriculaResponseDTO obtener(@PathVariable Long idMatricula) {
        return obtenerMatriculaUseCase.obtener(idMatricula);
    }

    @GetMapping("/validar-y-confirmar/{idMatricula}")
    public MatriculaResponseDTO validarYConfirmar(@PathVariable Long idMatricula) {
        return validarYConfirmarMatriculaUseCase.validarYConfirmar(idMatricula);
    }

    @GetMapping("/ficha-estudiante/{estudianteId}")
    public ResumenFichaEstudianteDTO fichaEstudiante(@PathVariable Long estudianteId) {
        return obtenerFichaEstudianteUseCase.obtenerFicha(estudianteId);
    }
}