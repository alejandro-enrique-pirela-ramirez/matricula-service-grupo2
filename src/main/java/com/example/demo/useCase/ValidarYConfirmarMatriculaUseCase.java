package com.example.demo.useCase;

import com.example.demo.bean.dto.MatriculaResponseDTO;

public interface ValidarYConfirmarMatriculaUseCase {
    MatriculaResponseDTO validarYConfirmar(Long idMatricula);
}