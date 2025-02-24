package com.sistema.intranet.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "tbNota", schema = "Seguimiento")
public class TbNota implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "alumno")
    private String alumno;

    @Column(name = "estado")
    private String estado;

    @Column(name = "curso")
    private String curso;

    @Column(name = "semestre")
    private String semestre;

    @Column(name = "nota")
    private Double nota;
}
