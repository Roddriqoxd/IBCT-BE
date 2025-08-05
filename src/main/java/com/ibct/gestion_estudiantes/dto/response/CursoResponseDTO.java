package com.ibct.gestion_estudiantes.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CursoResponseDTO {
    private Long id;
    private String nombre;
    private String modalidad;
    private double costoMensual;
    private double costoCompleto;
    private Integer duracionMeses;
    private String estado;
    private List<HorarioResponseDTO> horarios;
}
