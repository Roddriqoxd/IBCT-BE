package com.ibct.gestion_estudiantes.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class NotaDTO {
    private Long id;
    private String evaluacion;
    private double nota;
    private Date fechaRegistro;
    private Long inscripcionId;
}
