package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.bean.entity.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}