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
    @ManyToOne
    @JoinColumn (name = "alumno", nullable = false)
    private TbAlumno alumno;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "carrera", nullable = false)
    private TbCarrera carrera;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "especialidad", nullable = false)
    private TbEspecialidad especialidad;

    @Column(name = "curricula")
    private Integer curricula;

    @Column(name = "estado_alumno", nullable = false)
    private Integer estadoAlumno;

    @Column(name = "semestre_ingreso", nullable = false)
    private String semestreIngreso;

    @Column(name = "monto_maestria")
    private BigDecimal montoMaestria;
}
