package com.ibct.gestion_estudiantes.repository;

import com.ibct.gestion_estudiantes.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
}

