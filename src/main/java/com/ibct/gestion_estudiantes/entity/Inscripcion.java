package com.ibct.gestion_estudiantes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    private String estado;

    private String estadoCurso;

    private String estadoPago;

    private String tipoInscripcion;

    private String estadoCertificado;

    @Column(length = 1000, nullable = true)
    private String Observacion;

    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "horario_id")
    private Horario horario;

    @OneToMany(mappedBy = "inscripcion")
    private List<Pago> pagos;

    @OneToMany(mappedBy = "inscripcion")
    private List<Nota> notas;
}
