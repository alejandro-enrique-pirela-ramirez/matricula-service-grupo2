package com.example.demo.bean.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.bean.enums.EstadoMatricula;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "matricula")
@Data
@RequiredArgsConstructor
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigoMatricula;
    private LocalDateTime fechaMatricula;
    private Long estudianteId;
    private String periodoAcademico;

    @Column(name = "estado_matricula")
    @Enumerated(EnumType.STRING)
    private EstadoMatricula estadoMatricula;

    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleMatricula> detalles = new ArrayList<>();
}