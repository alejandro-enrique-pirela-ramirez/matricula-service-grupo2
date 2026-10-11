package com.example.demo.bean.dto;

import lombok.*;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class DetalleCursoMatriculadoDTO {
    private Long idCurso;
    private String codigoCurso;
    private String nombreCurso;
    private String seccion;
    private Integer creditos;
    private Double costoPorCredito;
    private Double subtotalCurso;
}