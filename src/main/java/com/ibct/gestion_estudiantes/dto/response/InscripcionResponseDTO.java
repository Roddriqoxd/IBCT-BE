package com.ibct.gestion_estudiantes.dto.response;

import com.ibct.gestion_estudiantes.dto.CursoDTO;
import com.ibct.gestion_estudiantes.dto.EstudianteDTO;
import com.ibct.gestion_estudiantes.dto.HorarioDTO;
import com.ibct.gestion_estudiantes.dto.PagoDTO;
import com.ibct.gestion_estudiantes.entity.Deuda;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@Getter
public class InscripcionResponseDTO {
    private Long id;
    private Date fechaInicio;
    private String estado;
    private String estadoCurso;
    private String estadoCertificado;
    private EstudianteDTO estudiante;
    private String estadoPago;
    private String tipoInscripcion;
    private String Observacion;
    private HorarioDTO horario;
    private CursoDTO curso;
    private List<PagoDTO> pagos;
    private List<DeudaResponseDTO> deudas;
}
