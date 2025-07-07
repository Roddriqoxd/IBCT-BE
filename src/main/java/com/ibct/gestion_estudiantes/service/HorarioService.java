package com.ibct.gestion_estudiantes.service;

import com.ibct.gestion_estudiantes.entity.Horario;
import com.ibct.gestion_estudiantes.repository.HorarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HorarioService {
    private final HorarioRepository repository;

    public HorarioService(HorarioRepository repository) {
        this.repository = repository;
    }

    public List<Horario> listar() {
        return repository.findAll();
    }

    public Optional<Horario> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Horario guardar(Horario horario) {
        return repository.save(horario);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

