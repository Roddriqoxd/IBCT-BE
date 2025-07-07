package com.ibct.gestion_estudiantes.service;

import com.ibct.gestion_estudiantes.entity.Estudiante;
import com.ibct.gestion_estudiantes.repository.EstudianteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    private final EstudianteRepository repository;

    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public List<Estudiante> listar() {
        return repository.findAll();
    }

    public Optional<Estudiante> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Estudiante guardar(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
