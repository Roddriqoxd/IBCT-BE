package com.ibct.gestion_estudiantes.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EstudianteDTO {
    private Long id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String ci;
    private String rol;
    private Date fechaRegistro;
}
