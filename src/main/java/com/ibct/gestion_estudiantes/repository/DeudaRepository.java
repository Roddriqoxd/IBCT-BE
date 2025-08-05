package com.ibct.gestion_estudiantes.repository;

import com.ibct.gestion_estudiantes.entity.Deuda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeudaRepository extends JpaRepository<Deuda, Long> {
}
