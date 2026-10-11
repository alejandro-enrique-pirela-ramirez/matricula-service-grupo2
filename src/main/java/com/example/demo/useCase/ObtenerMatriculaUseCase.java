package com.example.demo.useCase;

import com.example.demo.bean.dto.MatriculaResponseDTO;

public interface ObtenerMatriculaUseCase {
    MatriculaResponseDTO obtener(Long idMatricula);
}