package com.example.demo.bean.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class MatriculaResponseDTO {
    private Long idMatricula;
    private String codigoMatricula;
    private LocalDateTime fechaMatricula;
    private Long estudianteId;
    private String periodoAcademico;
    private String estadoMatricula;
    private List<DetalleCursoMatriculadoDTO> listaCursosMatriculados;
    private Integer totalCreditosInscritos;
    private Double montoTotalPension;
}