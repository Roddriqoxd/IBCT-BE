package com.ibct.gestion_estudiantes.mapperDTO;

import com.ibct.gestion_estudiantes.dto.CursoDTO;
import com.ibct.gestion_estudiantes.entity.Curso;

public class CursoMapper {

    public static CursoDTO toDto(Curso curso) {
        CursoDTO dto = new CursoDTO();
        dto.setId(curso.getId());
        dto.setNombre(curso.getNombre());
        dto.setDuracionMeses(curso.getDuracionMeses());
        dto.setModalidad(curso.getModalidad());
        dto.setEstado(curso.getEstado());
        return dto;
    }

    public static Curso toEntity(CursoDTO dto) {
        Curso curso = new Curso();
        curso.setNombre(dto.getNombre());
        curso.setDuracionMeses(dto.getDuracionMeses());
        curso.setModalidad(dto.getModalidad());
        curso.setEstado(dto.getEstado());
        return curso;
    }
}

