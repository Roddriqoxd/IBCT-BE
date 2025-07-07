package com.ibct.gestion_estudiantes.controller;

import com.ibct.gestion_estudiantes.dto.EstudianteDTO;
import com.ibct.gestion_estudiantes.entity.Estudiante;
import com.ibct.gestion_estudiantes.mapperDTO.EstudianteMapper;
import com.ibct.gestion_estudiantes.service.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService service;

    public EstudianteController(EstudianteService service) {
        this.service = service;
    }

    @GetMapping
    public List<EstudianteDTO> listar() {
        return service.listar().stream()
                .map(EstudianteMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDTO> obtener(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(est -> ResponseEntity.ok(EstudianteMapper.toDto(est)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstudianteDTO> crear(@RequestBody EstudianteDTO dto) {
        Estudiante nuevo = EstudianteMapper.toEntity(dto);
        Estudiante guardado = service.guardar(nuevo);
        return ResponseEntity.ok(EstudianteMapper.toDto(guardado));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<EstudianteDTO> actualizar(@PathVariable Long id, @RequestBody EstudianteDTO dto) {
//        return service.buscarPorId(id).map(estudiante -> {
//            estudiante.setNombre(dto.getNombre());
//            estudiante.setApellido(dto.getApellido());
//            estudiante.setTelefono(dto.getTelefono());
//            estudiante.setCi(dto.getCi());
//            Estudiante actualizado = service.guardar(estudiante);
//            return ResponseEntity.ok(EstudianteMapper.toDto(actualizado));
//        }).orElse(ResponseEntity.notFound().build());
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.buscarPorId(id).isPresent()) {
            service.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

