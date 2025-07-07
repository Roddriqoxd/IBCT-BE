package com.ibct.gestion_estudiantes.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String horaInicio;
    private String horaFin;
    private String turno;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}