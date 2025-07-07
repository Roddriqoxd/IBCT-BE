package com.ibct.gestion_estudiantes.repository;

import com.ibct.gestion_estudiantes.entity.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

// InscripcionRepository.java
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {}
