package com.ibct.gestion_estudiantes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String ci;
    private String rol;

    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    @OneToMany(mappedBy = "estudiante")
    List<Inscripcion> inscripciones;

    @PrePersist
    protected void onCreate() {
        this.fechaRegistro = new Date();
    }
}
