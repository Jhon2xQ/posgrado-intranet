package com.sistema.intranet.services;

import com.sistema.intranet.dtos.PagoDetalleDto;
import com.sistema.intranet.repositories.PagoDetalleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class PagoDetalleService {

    private final PagoDetalleRepository pagoDetalleRepository;
    private final ModelMapper pagoDetalleMapper;

    /*=================================MÉTODOS=================================*/

    //Obtener-todos-los-pago-detalle-del-alumno-----------------------------
    public List<PagoDetalleDto> getPagosAlumno(String alumno){
        return pagoDetalleRepository.buscarPagosAlumno(alumno)
                .stream().map(pago ->
                        new PagoDetalleDto(
                                (String) pago[0], //recibo
                                (String) pago[2], //semestre
                                ((BigDecimal) pago[3]).doubleValue(), //monto
                                 pago[4].toString(), //estado
                                (Date) pago[5], //fecha
                                (String) pago[6]) //lugar de pago
                ).collect(Collectors.toList());
    }
}
