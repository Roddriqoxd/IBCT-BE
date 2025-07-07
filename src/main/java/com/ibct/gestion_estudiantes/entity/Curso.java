package com.ibct.gestion_estudiantes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String modalidad;

    private Integer duracionMeses;

    private String estado;

    @OneToMany(mappedBy = "curso")
    private List<Horario> horarios;

    @OneToMany(mappedBy = "curso")
    private List<Inscripcion> inscripciones;
}
