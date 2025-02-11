package com.sistema.intranet.models;

import com.sistema.intranet.models.IdClasses.TbEspecialidadId;
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

@Table(name = "tbEspecialidad")
public class TbEspecialidad implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "especialidad", nullable = false)
    private String especialidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrera", nullable = false)
    private TbCarrera carrera;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "especialidad")
    private List<TbAlumnoCarrera> alumnoCarreras;
}
