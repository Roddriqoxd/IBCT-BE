package com.ibct.gestion_estudiantes.mapperDTO;

import com.ibct.gestion_estudiantes.dto.NotaDTO;
import com.ibct.gestion_estudiantes.entity.Inscripcion;
import com.ibct.gestion_estudiantes.entity.Nota;

public class NotaMapper {

    public static NotaDTO toDto(Nota nota) {
        NotaDTO dto = new NotaDTO();
        dto.setId(nota.getId());
        dto.setEvaluacion(nota.getEvaluacion());
        dto.setNota(nota.getNota());
        dto.setFechaRegistro(nota.getFechaRegistro());
        dto.setInscripcionId(nota.getInscripcion() != null ? nota.getInscripcion().getId() : null);
        return dto;
    }

    public static Nota toEntity(NotaDTO dto) {
        Nota nota = new Nota();
        nota.setEvaluacion(dto.getEvaluacion());
        nota.setNota(dto.getNota());
        if (dto.getInscripcionId() != null) {
            Inscripcion insc = new Inscripcion();
            insc.setId(dto.getInscripcionId());
            nota.setInscripcion(insc);
        }
        return nota;
    }
}

