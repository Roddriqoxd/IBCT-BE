package com.ibct.gestion_estudiantes.repository;

import com.ibct.gestion_estudiantes.entity.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

// NotaRepository.java
public interface NotaRepository extends JpaRepository<Nota, Long> {}
