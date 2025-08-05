package com.ibct.gestion_estudiantes.mapperDTO;

import com.ibct.gestion_estudiantes.dto.InscripcionDTO;
import com.ibct.gestion_estudiantes.entity.Curso;
import com.ibct.gestion_estudiantes.entity.Estudiante;
import com.ibct.gestion_estudiantes.entity.Horario;
import com.ibct.gestion_estudiantes.entity.Inscripcion;

public class InscripcionMapper {

    public static InscripcionDTO toDto(Inscripcion insc) {
        InscripcionDTO dto = new InscripcionDTO();
        dto.setId(insc.getId());
        dto.setFechaInicio(insc.getFechaInicio());
        dto.setEstado(insc.getEstado());
        dto.setEstadoCurso(insc.getEstadoCurso());
        dto.setEstadoCertificado(insc.getEstadoCertificado());
        dto.setEstadoPago(insc.getEstadoPago());
        dto.setTipoInscripcion(insc.getTipoInscripcion());
        dto.setObservacion(insc.getObservacion() != null ? insc.getObservacion() : null);
        dto.setEstudianteId(insc.getEstudiante() != null ? insc.getEstudiante().getId() : null);
        dto.setCursoId(insc.getCurso() != null ? insc.getCurso().getId() : null);
        dto.setHorarioId(insc.getHorario() != null ? insc.getHorario().getId() : null);
        return dto;
    }

    public static Inscripcion toEntity(InscripcionDTO dto) {
        Inscripcion insc = new Inscripcion();
        insc.setFechaInicio(dto.getFechaInicio());
        insc.setEstado(dto.getEstado());
        insc.setEstadoCurso(dto.getEstadoCurso());
        insc.setEstadoPago(dto.getEstadoPago());
        insc.setEstadoCertificado(dto.getEstadoCertificado());
        insc.setTipoInscripcion(dto.getTipoInscripcion());

        if (dto.getObservacion() != null) {
            insc.setObservacion(dto.getObservacion());
        }

        if (dto.getEstudianteId() != null) {
            Estudiante est = new Estudiante();
            est.setId(dto.getEstudianteId());
            insc.setEstudiante(est);
        }

        if (dto.getCursoId() != null) {
            Curso curso = new Curso();
            curso.setId(dto.getCursoId());
            insc.setCurso(curso);
        }

        if (dto.getHorarioId() != null) {
            Horario horario = new Horario();
            horario.setId(dto.getHorarioId());
            insc.setHorario(horario);
        }

        return insc;
    }
}

