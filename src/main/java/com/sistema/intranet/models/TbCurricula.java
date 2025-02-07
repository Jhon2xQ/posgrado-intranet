package com.sistema.intranet.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "tbCurricula")
public class TbCurricula implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "curricula", nullable = false)
    private Integer curricula;

    @Id
    @Column(name = "carrera", nullable = false)
    private String carrera;

    @Column(name = "estado")
    private String estado;

    @Column(name = "nombre")
    private String nombre;


}
