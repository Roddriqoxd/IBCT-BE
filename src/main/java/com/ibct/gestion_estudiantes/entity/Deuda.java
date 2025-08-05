package com.ibct.gestion_estudiantes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Deuda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double monto;

    private String fechaPago;

    private String estadoDePago;

    @Column(length = 1000, nullable = true)
    private String detalle;

    @ManyToOne
    @JoinColumn(name = "inscripcion_id", nullable = true)
    private Inscripcion inscripcion;
}
