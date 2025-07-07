package com.ibct.gestion_estudiantes.mapperDTO;

import com.ibct.gestion_estudiantes.dto.EstudianteDTO;
import com.ibct.gestion_estudiantes.entity.Estudiante;

public class EstudianteMapper {

    public static EstudianteDTO toDto(Estudiante estudiante) {
        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(estudiante.getId());
        dto.setNombre(estudiante.getNombre());
        dto.setApellidoPaterno(estudiante.getApellidoPaterno());
        dto.setApellidoMaterno(estudiante.getApellidoMaterno());
        dto.setTelefono(estudiante.getTelefono());
        dto.setCi(estudiante.getCi());
        dto.setRol(estudiante.getRol());
        dto.setFechaRegistro(estudiante.getFechaRegistro());
        return dto;
    }

    public static Estudiante toEntity(EstudianteDTO dto) {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre(dto.getNombre());
        estudiante.setApellidoPaterno(dto.getApellidoPaterno());
        estudiante.setApellidoMaterno(dto.getApellidoMaterno());
        estudiante.setRol(dto.getRol());
        estudiante.setTelefono(dto.getTelefono());
        estudiante.setCi(dto.getCi());
        // Nota: fechaRegistro se setea automáticamente en @PrePersist
        return estudiante;
    }
}

