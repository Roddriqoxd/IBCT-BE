package com.ibct.gestion_estudiantes.service;

import com.ibct.gestion_estudiantes.entity.Deuda;
import com.ibct.gestion_estudiantes.repository.DeudaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeudaService {

    private final DeudaRepository deudaRepository;

    @Autowired
    public DeudaService(DeudaRepository deudaRepository) {
        this.deudaRepository = deudaRepository;
    }

    public List<Deuda> listarTodas() {
        return deudaRepository.findAll();
    }

    public Deuda obtenerPorId(Long id) {
        return deudaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Deuda no encontrada con id: " + id));
    }

    public Deuda guardar(Deuda deuda) {
        return deudaRepository.save(deuda);
    }

    public void eliminar(Long id) {
        deudaRepository.deleteById(id);
    }
}
