package com.ibct.gestion_estudiantes.service;

import com.ibct.gestion_estudiantes.dto.CursoDTO;
import com.ibct.gestion_estudiantes.dto.EstudianteDTO;
import com.ibct.gestion_estudiantes.dto.HorarioDTO;
import com.ibct.gestion_estudiantes.dto.PagoDTO;
import com.ibct.gestion_estudiantes.dto.response.DeudaResponseDTO;
import com.ibct.gestion_estudiantes.dto.response.InscripcionResponseDTO;
import com.ibct.gestion_estudiantes.entity.*;
import com.ibct.gestion_estudiantes.mapperDTO.*;
import com.ibct.gestion_estudiantes.repository.InscripcionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InscripcionService {
    private final InscripcionRepository repository;

    public InscripcionService(InscripcionRepository repository) {
        this.repository = repository;
    }

    public List<Inscripcion> listar() {
        return repository.findAll();
    }

    public List<InscripcionResponseDTO> listarInscripciones() {
        List<Inscripcion> inscripcion = repository.findAll();

        return inscripcion.stream().map(inscrito -> {
            InscripcionResponseDTO dto = new InscripcionResponseDTO();
            dto.setId(inscrito.getId());
            dto.setFechaInicio(inscrito.getFechaInicio());
            dto.setEstado(inscrito.getEstado());
            dto.setEstadoCurso(inscrito.getEstadoCurso());
            dto.setEstadoCertificado(inscrito.getEstadoCertificado());
            dto.setTipoInscripcion(inscrito.getTipoInscripcion());
            dto.setEstadoPago(inscrito.getEstadoPago());
//            dto.setDeudas(inscrito.getDeudas());

            Estudiante estudiante = inscrito.getEstudiante();
            EstudianteDTO estudianteDTO = EstudianteMapper.toDto(estudiante);

            Curso curso = inscrito.getCurso();
            CursoDTO cursoDTO = CursoMapper.toDto(curso);

            Horario horario = inscrito.getHorario();
            HorarioDTO horarioDTO = HorarioMapper.toDto(horario);

            List<Pago> pago = inscrito.getPagos();
            List<PagoDTO> pagoDTO = pago
                    .stream()
                    .map(PagoMapper::toDto).collect(Collectors.toList());

            List<Deuda> deudas = inscrito.getDeudas();
            List<DeudaResponseDTO> deudasDTO = deudas
                    .stream()
                    .map(DeudaMapper::toDto).collect(Collectors.toList());

            dto.setPagos(pagoDTO);
            dto.setDeudas(deudasDTO);
            dto.setEstudiante(estudianteDTO);
            dto.setHorario(horarioDTO);
            dto.setCurso(cursoDTO);

            return dto;
        }).collect(Collectors.toList());
    }

    public Optional<Inscripcion> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Inscripcion guardar(Inscripcion inscripcion) {
        return repository.save(inscripcion);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

