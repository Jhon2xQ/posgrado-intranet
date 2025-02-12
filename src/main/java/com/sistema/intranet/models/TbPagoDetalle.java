package com.sistema.intranet.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "tbPagoDetalle", schema = "Caja")
public class TbPagoDetalle implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "recibo")
    private String recibo;

    @ManyToOne()
    @JoinColumn(name = "alumno", nullable = false)
    @JsonIgnore
    private TbAlumno alumno;

    @Column(name = "semestre")
    private String semestre;

    @Column(name = "monto")
    private BigDecimal monto;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "lugarpago")
    private String lugarpago;
}
