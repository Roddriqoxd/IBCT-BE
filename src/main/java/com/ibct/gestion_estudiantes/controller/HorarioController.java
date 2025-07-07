package com.ibct.gestion_estudiantes.controller;

import com.ibct.gestion_estudiantes.dto.HorarioDTO;
import com.ibct.gestion_estudiantes.entity.Curso;
import com.ibct.gestion_estudiantes.entity.Horario;
import com.ibct.gestion_estudiantes.mapperDTO.HorarioMapper;
import com.ibct.gestion_estudiantes.repository.HorarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    private final HorarioRepository repository;

    public HorarioController(HorarioRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<HorarioDTO> listar() {
        return repository.findAll().stream()
                .map(HorarioMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HorarioDTO> obtener(@PathVariable Long id) {
        return repository.findById(id)
                .map(horario -> ResponseEntity.ok(HorarioMapper.toDto(horario)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HorarioDTO> crear(@RequestBody HorarioDTO dto) {
        Horario horario = HorarioMapper.toEntity(dto);
        Horario guardado = repository.save(horario);
        return ResponseEntity.ok(HorarioMapper.toDto(guardado));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<HorarioDTO> actualizar(@PathVariable Long id, @RequestBody HorarioDTO dto) {
//        return repository.findById(id).map(horario -> {
//            horario.setModalidad(dto.getModalidad());
//            horario.setHoraInicio(dto.getHoraInicio());
//            horario.setHoraFin(dto.getHoraFin());
//
//            if (dto.getCursoId() != null) {
//                Curso curso = new Curso();
//                curso.setId(dto.getCursoId());
//                horario.setCurso(curso);
//            }
//
//            Horario actualizado = repository.save(horario);
//            return ResponseEntity.ok(HorarioMapper.toDto(actualizado));
//        }).orElse(ResponseEntity.notFound().build());
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
