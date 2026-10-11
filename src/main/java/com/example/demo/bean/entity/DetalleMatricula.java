package com.example.demo.bean.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalle_matricula")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class DetalleMatricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matricula_id")
    private Matricula matricula;

    private Long idCurso;
    private String codigoCurso;
    private String nombreCurso;
    private String seccion;
    private Integer creditos;
    private Double costoPorCredito;
    private Double subtotalCurso;
}