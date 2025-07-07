package com.ibct.gestion_estudiantes.controller;

import com.ibct.gestion_estudiantes.dto.CursoDTO;
import com.ibct.gestion_estudiantes.dto.response.CursoResponseDTO;
import com.ibct.gestion_estudiantes.entity.Curso;
import com.ibct.gestion_estudiantes.mapperDTO.CursoMapper;
import com.ibct.gestion_estudiantes.repository.CursoRepository;
import com.ibct.gestion_estudiantes.service.CursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final CursoRepository repository;

    private final CursoService cursoService;

    public CursoController(CursoRepository repository,
                           CursoService cursoService) {
        this.repository = repository;
        this.cursoService = cursoService;
    }

//    @GetMapping
//    public List<CursoDTO> listar() {
//        return repository.findAll().stream()
//                .map(CursoMapper::toDto)
//                .collect(Collectors.toList());
//    }

    @GetMapping
    public List<CursoResponseDTO> listarCursosConHorarios() {
        return cursoService.listarCursosConHorarios();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> obtener(@PathVariable Long id) {
        return repository.findById(id)
                .map(curso -> ResponseEntity.ok(CursoMapper.toDto(curso)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CursoDTO> crear(@RequestBody CursoDTO cursoDTO) {
        Curso curso = CursoMapper.toEntity(cursoDTO);
        Curso saved = repository.save(curso);
        return ResponseEntity.ok(CursoMapper.toDto(saved));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<CursoDTO> actualizar(@PathVariable Long id, @RequestBody CursoDTO datos) {
//        return repository.findById(id).map(curso -> {
//            curso.setNombre(datos.getNombre());
//            curso.setDuracionMeses(datos.getDuracionMeses());
//            Curso actualizado = repository.save(curso);
//            return ResponseEntity.ok(CursoMapper.toDto(actualizado));
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


