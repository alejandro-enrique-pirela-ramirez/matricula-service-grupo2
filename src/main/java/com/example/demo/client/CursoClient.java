package com.example.demo.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.bean.dto.CursoDisponibilidadDTO;

@FeignClient(name = "curso-service-grupo2")
public interface CursoClient {

    @GetMapping("/api/v1/cursos/{idCurso}")
    CursoDisponibilidadDTO obtenerCurso(@PathVariable("idCurso") Long idCurso);

    @GetMapping("/api/v1/cursos/estudiante/{estudianteId}")
    List<CursoDisponibilidadDTO> listarPorEstudiante(@PathVariable("estudianteId") Long estudianteId);
}