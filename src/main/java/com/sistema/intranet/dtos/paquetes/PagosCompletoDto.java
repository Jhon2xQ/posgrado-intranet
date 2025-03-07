package com.sistema.intranet.dtos.paquetes;

import com.sistema.intranet.dtos.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PagosCompletoDto {
    private List<PagoDetalleDto> pagoDetalle;
    private ResumenGPDto resumenGeneral;
}
