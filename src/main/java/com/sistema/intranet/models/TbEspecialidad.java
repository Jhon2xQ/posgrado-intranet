package com.sistema.intranet.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

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

    @Id
    @Column(name = "carrera", nullable = false)
    private String carrera;

    @Column(name = "descripcion")
    private String descripcion;

}
