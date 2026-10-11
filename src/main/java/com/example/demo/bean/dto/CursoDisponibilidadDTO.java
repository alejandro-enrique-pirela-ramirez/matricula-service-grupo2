package com.example.demo.bean.dto;

import lombok.*;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class CursoDisponibilidadDTO {
    private Long idCurso;
    private String codigoCurso;
    private String nombreCurso;
    private Integer vacantesDisponibles;
    private String prerrequisito;
    private String estadoCurso;
}