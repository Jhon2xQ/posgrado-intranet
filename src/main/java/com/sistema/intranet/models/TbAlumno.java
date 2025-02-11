package com.sistema.intranet.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "tbAlumno")
public class TbAlumno implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "alumno", nullable = false)
    private String alumno;

    @ManyToOne
    @JoinColumn(name = "persona", nullable = false)
    private TbPersona persona;

    @OneToOne(mappedBy = "alumno")
    private TbAlumnoCarrera alumnoCarrera;

    @OneToMany(mappedBy = "alumno")
    private List<TbPagoDetalle> pagoDetalles;
}
