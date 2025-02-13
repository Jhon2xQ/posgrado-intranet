package com.sistema.intranet.dtos;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class PagoDetalleDto {
    private String recibo;
    private String semestre;
    private Double monto;
    private String estado;
    private Date fecha;
    private String lugarPago;
}
