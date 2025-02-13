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

    @Column(name = "alumno")
    private String alumno;

    @Column(name = "semestre")
    private String semestre;

    @Column(name = "monto")
    private Double monto;

    @Column(name = "estado")
    private String estado;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "lugarpago")
    private String lugarpago;
}
