package com.example.demo.bean.dto;

import lombok.*;

import java.util.List;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class ResumenFichaEstudianteDTO {
    private Long estudianteId;
    private String nombreEstudiante;
    private String carrera;
    private String sede;
    private Integer totalMatriculasRealizadas;
    private Double promedioPonderadoAcumulado;
    private List<MatriculaResponseDTO> historialMatriculas;
    private List<CursoDisponibilidadDTO> catalogoCursosElegibles;
    private String situacionAcademica;
}