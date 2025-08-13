package com.ibct.gestion_estudiantes.dto.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeudaResponseDTO {
    private Long id;
    private double monto;
    private String fechaPago;
    private String estadoDePago;
    private String detalle;
    private Long inscripcionId;
}