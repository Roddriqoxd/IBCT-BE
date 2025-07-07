package com.ibct.gestion_estudiantes.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HorarioResponseDTO {
    private Long id;
    private String horaInicio;
    private String horaFin;
    private String turno;
    private String estado;
}

