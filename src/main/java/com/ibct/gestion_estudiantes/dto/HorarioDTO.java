package com.ibct.gestion_estudiantes.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HorarioDTO {
    private Long id;
    private String horaInicio;
    private String horaFin;
    private String turno;
    private String estado;
    private Long cursoId;
}

