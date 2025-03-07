package com.sistema.intranet.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagoDetalleDto {
    private String recibo;
    private String semestre;
    private Double monto;
    private String estado;
    private Date fecha;
    private String lugarPago;
}
