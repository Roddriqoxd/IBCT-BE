package com.ibct.gestion_estudiantes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String evaluacion;

    private double nota;

    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "inscripcion_id")
    private Inscripcion inscripcion;

    @PrePersist
    protected void onCreate() {
        this.fechaRegistro = new Date();
    }
}
