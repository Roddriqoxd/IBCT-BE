package com.ibct.gestion_estudiantes.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class InscripcionDTO {
    private Long id;
    private Date fechaInicio;
    private String estado;
    private String estadoCurso;
    private String tipoInscripcion;
    private String estadoPago;
    private String estadoCertificado;
    private String Observacion;
    private Long estudianteId;
    private Long horarioId;
    private Long cursoId;
}
