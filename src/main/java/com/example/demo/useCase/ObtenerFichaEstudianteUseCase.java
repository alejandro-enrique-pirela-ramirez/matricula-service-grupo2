package com.example.demo.useCase;

import com.example.demo.bean.dto.ResumenFichaEstudianteDTO;

public interface ObtenerFichaEstudianteUseCase {
    ResumenFichaEstudianteDTO obtenerFicha(Long estudianteId);
    
}