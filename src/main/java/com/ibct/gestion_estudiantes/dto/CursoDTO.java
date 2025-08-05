package com.ibct.gestion_estudiantes.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CursoDTO {
    private Long id;
    private String nombre;
    private String modalidad;
    private double costoMensual;
    private double costoCompleto;
    private Integer duracionMeses;
    private String estado;
}
