package com.sistema.intranet.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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


@Table(name = "tbCarrera", schema = "Academico")
public class TbCarrera implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "carrera", nullable = false)
    private String carrera;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo_carrera")
    private String tipoCarrera;

    @OneToMany(mappedBy = "carrera")
    @JsonIgnore
    private List<TbAlumnoCarrera> alumnoCarreras;
}
