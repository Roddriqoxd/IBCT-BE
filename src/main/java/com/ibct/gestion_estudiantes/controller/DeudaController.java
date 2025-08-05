package com.ibct.gestion_estudiantes.controller;

import com.ibct.gestion_estudiantes.dto.response.DeudaResponseDTO;
import com.ibct.gestion_estudiantes.entity.Deuda;
import com.ibct.gestion_estudiantes.mapperDTO.DeudaMapper;
import com.ibct.gestion_estudiantes.service.DeudaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/deudas")
public class DeudaController {

    private final DeudaService deudaService;

    @Autowired
    public DeudaController(DeudaService deudaService) {
        this.deudaService = deudaService;
    }

    @GetMapping
    public List<DeudaResponseDTO> listarTodas() {
        return deudaService.listarTodas()
                .stream()
                .map(DeudaMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Deuda obtenerPorId(@PathVariable Long id) {
        return deudaService.obtenerPorId(id);
    }

    @PostMapping
    public DeudaResponseDTO crear(@RequestBody DeudaResponseDTO deudaDTO) {
        Deuda deuda = DeudaMapper.toEntity(deudaDTO);
        return DeudaMapper.toDto(deudaService.guardar(deuda));
    }

    @PutMapping("/{id}")
    public Deuda actualizar(@PathVariable Long id, @RequestBody Deuda deuda) {
        Deuda existente = deudaService.obtenerPorId(id);
        existente.setMonto(deuda.getMonto());
        existente.setFechaPago(deuda.getFechaPago());
        existente.setEstadoDePago(deuda.getEstadoDePago());
        existente.setDetalle(deuda.getDetalle());
        existente.setInscripcion(deuda.getInscripcion());
        return deudaService.guardar(existente);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        deudaService.eliminar(id);
    }
}

