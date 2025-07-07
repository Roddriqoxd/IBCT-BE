package com.ibct.gestion_estudiantes.dto.response;

import com.ibct.gestion_estudiantes.dto.HorarioDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CursoResponseDTO {
    private Long id;
    private String nombre;
    private String modalidad;
    private Integer duracionMeses;
    private String estado;
    private List<HorarioResponseDTO> horarios;
}
