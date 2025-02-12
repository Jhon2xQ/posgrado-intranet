package com.sistema.intranet.services;

import com.sistema.intranet.dtos.PagoDetalleDto;
import com.sistema.intranet.repositories.PagoDetalleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PagoDetalleService {

    private final PagoDetalleRepository pagoDetalleRepository;
    private final ModelMapper pagoDetalleMapper;

    /*=================================MÉTODOS=================================*/

    //Obtener-datos-de-pago-detalle-----------------------------
    public PagoDetalleDto getPagoDetalle(String pagoDetalle){
        return pagoDetalleMapper.map(pagoDetalleRepository.findById(pagoDetalle), PagoDetalleDto.class);
    }
}
