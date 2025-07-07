package com.ibct.gestion_estudiantes.mapperDTO;

import com.ibct.gestion_estudiantes.dto.HorarioDTO;
import com.ibct.gestion_estudiantes.entity.Curso;
import com.ibct.gestion_estudiantes.entity.Horario;

public class HorarioMapper {

    public static HorarioDTO toDto(Horario horario) {
        HorarioDTO dto = new HorarioDTO();
        dto.setId(horario.getId());
        dto.setHoraInicio(horario.getHoraInicio());
        dto.setHoraFin(horario.getHoraFin());
        dto.setCursoId(horario.getCurso().getId());
        dto.setTurno(horario.getTurno());
        dto.setEstado(horario.getEstado());
        return dto;
    }

    public static Horario toEntity(HorarioDTO dto) {
        Horario horario = new Horario();
        horario.setHoraInicio(dto.getHoraInicio());
        horario.setHoraFin(dto.getHoraFin());
        horario.setTurno(dto.getTurno());
        horario.setEstado(dto.getEstado());
        if (dto.getCursoId() != null) {
            Curso curso = new Curso();
            curso.setId(dto.getCursoId());
            horario.setCurso(curso);
        }

        return horario;
    }
}

