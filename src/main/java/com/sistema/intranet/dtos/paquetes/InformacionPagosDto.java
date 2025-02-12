package com.sistema.intranet.dtos.paquetes;

import com.sistema.intranet.dtos.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class InformacionPagosDto {
    private PersonaDto personaDto;
    private CarreraDto carreraDto;
    private EspecialidadDto especialidadDto;
    private List<PagoDetalleDto> pagoDetalleDto;
}
