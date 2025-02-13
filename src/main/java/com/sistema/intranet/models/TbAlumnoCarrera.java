package com.sistema.intranet.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sistema.intranet.models.IdClasses.TbAlumnoCarreraId;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "tbAlumnoCarrera", schema = "Academico")
@IdClass(TbAlumnoCarreraId.class)

public class TbAlumnoCarrera implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "alumno")
    private String alumno;

    @Id
    @Column(name = "carrera")
    private String carrera;

    @Column(name = "especialidad")
    private String especialidad;

    @Column(name = "curricula")
    private Integer curricula;

    @Column(name = "estado_alumno")
    private Integer estadoAlumno;

    @Column(name = "semestre_ingreso")
    private String semestreIngreso;

    @Column(name = "monto_maestria")
    private Double montoMaestria;
}
