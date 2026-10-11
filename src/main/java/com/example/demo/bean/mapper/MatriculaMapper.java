
package com.example.demo.bean.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.bean.dto.DetalleCursoMatriculadoDTO;
import com.example.demo.bean.dto.MatriculaResponseDTO;
import com.example.demo.bean.entity.DetalleMatricula;
import com.example.demo.bean.entity.Matricula;

@Mapper(componentModel = "spring")
public interface MatriculaMapper {

    
    DetalleCursoMatriculadoDTO toDetalleDto(DetalleMatricula detalle);

    @Mapping(target = "idMatricula", source = "id")
    @Mapping(target = "listaCursosMatriculados", source = "detalles")
    @Mapping(
        target = "totalCreditosInscritos",
        expression = """
            java(matricula.getDetalles() == null ? 0 :
                matricula.getDetalles().stream()
                    .filter(d -> d.getCreditos() != null)
                    .mapToInt(DetalleMatricula::getCreditos)
                    .sum())
            """
    )
    @Mapping(
        target = "montoTotalPension",
        expression = """
            java(matricula.getDetalles() == null ? 0.0 :
                matricula.getDetalles().stream()
                    .filter(d -> d.getSubtotalCurso() != null)
                    .mapToDouble(DetalleMatricula::getSubtotalCurso)
                    .sum())
            """
    )
    MatriculaResponseDTO toResponseDto(Matricula matricula);
}
