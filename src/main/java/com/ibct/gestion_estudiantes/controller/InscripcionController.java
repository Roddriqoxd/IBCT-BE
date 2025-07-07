package com.ibct.gestion_estudiantes.controller;

import com.ibct.gestion_estudiantes.dto.InscripcionDTO;
import com.ibct.gestion_estudiantes.dto.response.InscripcionResponseDTO;
import com.ibct.gestion_estudiantes.entity.Inscripcion;
import com.ibct.gestion_estudiantes.mapperDTO.InscripcionMapper;
import com.ibct.gestion_estudiantes.repository.InscripcionRepository;
import com.ibct.gestion_estudiantes.service.InscripcionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    private final InscripcionRepository repository;

    private final InscripcionService service;

    public InscripcionController(InscripcionRepository repository, InscripcionService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    public List<InscripcionResponseDTO> listar() {
        return service.listarInscripciones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InscripcionDTO> obtener(@PathVariable Long id) {
        return repository.findById(id)
                .map(i -> ResponseEntity.ok(InscripcionMapper.toDto(i)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InscripcionDTO> crear(@RequestBody InscripcionDTO dto) {
        Inscripcion insc = InscripcionMapper.toEntity(dto);
        return ResponseEntity.ok(InscripcionMapper.toDto(repository.save(insc)));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<InscripcionDTO> actualizar(@PathVariable Long id, @RequestBody InscripcionDTO dto) {
//        return repository.findById(id).map(insc -> {
//            insc.setFechaInicio(dto.getFechaInicio());
//            insc.setEstado(dto.getEstado());
//            return ResponseEntity.ok(InscripcionMapper.toDto(repository.save(insc)));
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

