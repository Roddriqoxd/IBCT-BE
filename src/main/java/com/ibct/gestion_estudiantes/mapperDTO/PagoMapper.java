package com.ibct.gestion_estudiantes.mapperDTO;

import com.ibct.gestion_estudiantes.dto.PagoDTO;
import com.ibct.gestion_estudiantes.entity.Inscripcion;
import com.ibct.gestion_estudiantes.entity.Pago;

public class PagoMapper {

    public static PagoDTO toDto(Pago pago) {
        PagoDTO dto = new PagoDTO();
        dto.setId(pago.getId());
        dto.setMonto(pago.getMonto());
        dto.setFechaPago(pago.getFechaPago());
        dto.setTipoDescuento(pago.getTipoDescuento());
        dto.setTipoPago(pago.getTipoPago());
        dto.setDetalle(pago.getDetalle());
        dto.setInscripcionId(pago.getInscripcion() != null ? pago.getInscripcion().getId() : null);
        return dto;
    }

    public static Pago toEntity(PagoDTO dto) {
        Pago pago = new Pago();
        pago.setMonto(dto.getMonto());
        pago.setTipoDescuento(dto.getTipoDescuento());
        pago.setTipoPago(dto.getTipoPago());
        pago.setDetalle(dto.getDetalle());
        if (dto.getInscripcionId() != null) {
            Inscripcion insc = new Inscripcion();
            insc.setId(dto.getInscripcionId());
            pago.setInscripcion(insc);
        }
        return pago;
    }
}
