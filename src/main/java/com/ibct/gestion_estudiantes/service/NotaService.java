package com.ibct.gestion_estudiantes.service;

import com.ibct.gestion_estudiantes.entity.Nota;
import com.ibct.gestion_estudiantes.repository.NotaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {
    private final NotaRepository repository;

    public NotaService(NotaRepository repository) {
        this.repository = repository;
    }

    public List<Nota> listar() {
        return repository.findAll();
    }

    public Optional<Nota> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Nota guardar(Nota nota) {
        return repository.save(nota);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
