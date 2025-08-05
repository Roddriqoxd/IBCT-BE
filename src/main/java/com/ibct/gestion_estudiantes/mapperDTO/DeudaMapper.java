package com.ibct.gestion_estudiantes.mapperDTO;

import com.ibct.gestion_estudiantes.dto.response.DeudaResponseDTO;
import com.ibct.gestion_estudiantes.entity.Deuda;
import com.ibct.gestion_estudiantes.entity.Inscripcion;

public class DeudaMapper {

    public static DeudaResponseDTO toDto(Deuda deuda) {
        DeudaResponseDTO dto = new DeudaResponseDTO();
        dto.setId(deuda.getId());
        dto.setMonto(deuda.getMonto());
        dto.setFechaPago(deuda.getFechaPago());
        dto.setEstadoDePago(deuda.getEstadoDePago());
        dto.setDetalle(deuda.getDetalle());

        if (deuda.getInscripcion() != null) {
            dto.setInscripcionId(deuda.getInscripcion().getId());
        }

        return dto;
    }

    public static Deuda toEntity(DeudaResponseDTO dto) {
        Deuda deuda = new Deuda();
        deuda.setMonto(dto.getMonto());
        deuda.setFechaPago(dto.getFechaPago());
        deuda.setEstadoDePago(dto.getEstadoDePago());
        deuda.setDetalle(dto.getDetalle());

        if (dto.getInscripcionId() != null) {
            Inscripcion inscripcion = new Inscripcion();
            inscripcion.setId(dto.getInscripcionId());
            deuda.setInscripcion(inscripcion);
        }

        return deuda;
    }
}
