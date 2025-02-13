package com.sistema.intranet.dtos.paquetes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResumenGPDto {
    private Double totalPagoPrograma;
    private Double totalPagosRealizados;
}
