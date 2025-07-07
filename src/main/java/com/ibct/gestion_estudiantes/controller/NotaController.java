package com.ibct.gestion_estudiantes.controller;

import com.ibct.gestion_estudiantes.dto.NotaDTO;
import com.ibct.gestion_estudiantes.entity.Nota;
import com.ibct.gestion_estudiantes.mapperDTO.NotaMapper;
import com.ibct.gestion_estudiantes.repository.NotaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notas")
public class NotaController {

    private final NotaRepository repository;

    public NotaController(NotaRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<NotaDTO> listar() {
        return repository.findAll().stream()
                .map(NotaMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaDTO> obtener(@PathVariable Long id) {
        return repository.findById(id)
                .map(n -> ResponseEntity.ok(NotaMapper.toDto(n)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<NotaDTO> crear(@RequestBody NotaDTO dto) {
        Nota nota = NotaMapper.toEntity(dto);
        return ResponseEntity.ok(NotaMapper.toDto(repository.save(nota)));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<NotaDTO> actualizar(@PathVariable Long id, @RequestBody NotaDTO dto) {
//        return repository.findById(id).map(nota -> {
//            nota.setEvaluacion(dto.getEvaluacion());
//            nota.setNota(dto.getNota());
//            return ResponseEntity.ok(NotaMapper.toDto(repository.save(nota)));
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


