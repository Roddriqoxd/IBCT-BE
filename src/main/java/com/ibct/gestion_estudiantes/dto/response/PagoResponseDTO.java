package com.ibct.gestion_estudiantes.dto.response;

import com.ibct.gestion_estudiantes.dto.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class PagoResponseDTO {
    private Long id;
    private double monto;
    private Date fechaPago;
    private String tipoPago;
    private String tipoDescuento;
    private String categoria;
    private String detalle;
    private InscripcionDTO inscripcion;
}
