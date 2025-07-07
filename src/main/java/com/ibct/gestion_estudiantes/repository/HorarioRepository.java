package com.ibct.gestion_estudiantes.repository;

import com.ibct.gestion_estudiantes.entity.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// HorarioRepository.java
public interface HorarioRepository extends JpaRepository<Horario, Long> {
}

