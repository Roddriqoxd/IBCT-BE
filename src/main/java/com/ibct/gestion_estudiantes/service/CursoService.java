package com.ibct.gestion_estudiantes.service;

import com.ibct.gestion_estudiantes.dto.response.CursoResponseDTO;
import com.ibct.gestion_estudiantes.dto.response.HorarioResponseDTO;
import com.ibct.gestion_estudiantes.entity.Curso;
import com.ibct.gestion_estudiantes.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoService {
    private final CursoRepository repository;

    private final HorarioService horarioService;

    public CursoService(CursoRepository repository,
                        HorarioService horarioService) {
        this.repository = repository;
        this.horarioService = horarioService;
    }

    public List<Curso> listar() {
        return repository.findAll();
    }

    public List<CursoResponseDTO> listarCursosConHorarios() {
        List<Curso> cursos = repository.findAll();

        return cursos.stream().map(curso -> {
            CursoResponseDTO dto = new CursoResponseDTO();
            dto.setId(curso.getId());
            dto.setNombre(curso.getNombre());
            dto.setModalidad(curso.getModalidad());
            dto.setDuracionMeses(curso.getDuracionMeses());
            dto.setEstado(curso.getEstado());

            List<HorarioResponseDTO> horarioDTOs = curso.getHorarios().stream().map(horario -> {
                HorarioResponseDTO hDto = new HorarioResponseDTO();
                hDto.setId(horario.getId());
                hDto.setHoraInicio(horario.getHoraInicio());
                hDto.setHoraFin(horario.getHoraFin());
                hDto.setTurno(horario.getTurno());
                hDto.setEstado(horario.getEstado());
                return hDto;
            }).collect(Collectors.toList());

            dto.setHorarios(horarioDTOs);
            return dto;
        }).collect(Collectors.toList());
    }

    public Optional<Curso> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Curso guardar(Curso curso) {
        return repository.save(curso);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
