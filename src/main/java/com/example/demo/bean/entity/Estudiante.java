package com.example.demo.bean.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estudiante")
@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String carrera;
    private String sede;
    private Double promedioPonderado;
}