package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {

    @EntityGraph(attributePaths = "detalles")
    Optional<Matricula> findWithDetallesById(Long id);

    @EntityGraph(attributePaths = "detalles")
    List<Matricula> findByEstudianteId(Long estudianteId);
}