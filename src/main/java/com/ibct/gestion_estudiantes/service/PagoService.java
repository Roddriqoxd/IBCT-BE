package com.ibct.gestion_estudiantes.service;

import com.ibct.gestion_estudiantes.entity.Pago;
import com.ibct.gestion_estudiantes.repository.PagoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {
    private final PagoRepository repository;

    public PagoService(PagoRepository repository) {
        this.repository = repository;
    }

    public List<Pago> listar() {
        return repository.findAll();
    }

    public Optional<Pago> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Pago guardar(Pago pago) {
        return repository.save(pago);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
