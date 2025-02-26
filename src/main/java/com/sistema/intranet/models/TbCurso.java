package com.sistema.intranet.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tbCurso", schema = "Matricula")
public class TbCurso implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "curso")
    private String curso;

    @Column(name = "semestre")
    private String semestre;

    @Column(name = "carrera")
    private String carrera;

    @Column(name = "especialidad")
    private String especialidad;

    @Column(name = "grupo")
    private String grupo;

    @Column(name = "curricula")
    private Integer curricula;

    @Column(name = "fecha_finalizacion")
    private Date fechaFinalizacion;
}
