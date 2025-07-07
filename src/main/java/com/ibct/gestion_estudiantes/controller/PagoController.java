package com.ibct.gestion_estudiantes.controller;

import com.ibct.gestion_estudiantes.dto.PagoDTO;
import com.ibct.gestion_estudiantes.entity.Pago;
import com.ibct.gestion_estudiantes.mapperDTO.PagoMapper;
import com.ibct.gestion_estudiantes.repository.PagoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoRepository repository;

    public PagoController(PagoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<PagoDTO> listar() {
        return repository.findAll().stream()
                .map(PagoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoDTO> obtener(@PathVariable Long id) {
        return repository.findById(id)
                .map(p -> ResponseEntity.ok(PagoMapper.toDto(p)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PagoDTO> crear(@RequestBody PagoDTO dto) {
        Pago pago = PagoMapper.toEntity(dto);
        return ResponseEntity.ok(PagoMapper.toDto(repository.save(pago)));
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<PagoDTO> actualizar(@PathVariable Long id, @RequestBody PagoDTO dto) {
//        return repository.findById(id).map(pago -> {
//            pago.setMonto(dto.getMonto());
//            pago.setMesPago(dto.getMesPago());
//            return ResponseEntity.ok(PagoMapper.toDto(repository.save(pago)));
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

