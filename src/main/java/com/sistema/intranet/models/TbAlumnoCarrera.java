package com.sistema.intranet.models;

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

@Table(name = "tbAlumnoCarrera")
@IdClass(TbAlumnoCarreraId.class)
public class TbAlumnoCarrera implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "alumno", nullable = false)
    private String alumno;

    @Id
    @Column(name = "carrera", nullable = false)
    private String carrera;

    @Id
    @Column(name = "especialidad", nullable = false)
    private String especialidad;

    @Column(name = "curricula")
    private Integer curricula;

    @Column(name = "estado_alumno", nullable = false)
    private Integer estadoAlumno;

    @Column(name = "semestre_ingreso", nullable = false)
    private String semestreIngreso;

    @Column(name = "monto_maestria")
    private BigDecimal montoMaestria;
}
