package com.ibct.gestion_estudiantes.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PagoDTO {
    private Long id;
    private double monto;
    private Date fechaPago;
    private String tipoPago;
    private String tipoDescuento;
    private String detalle;
    private Long inscripcionId;
}
