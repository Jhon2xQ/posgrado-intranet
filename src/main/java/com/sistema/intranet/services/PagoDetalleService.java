package com.sistema.intranet.services;

import com.sistema.intranet.dtos.PagoDetalleDto;
import com.sistema.intranet.repositories.PagoDetalleRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PagoDetalleService {

    private final PagoDetalleRepository pagoDetalleRepository;
    private final ModelMapper pagoDetalleMapper;

    /*=================================MÉTODOS=================================*/

    //Obtener-un-pago-detalle-----------------------------
    public PagoDetalleDto getPagoDetalle(String pagoDetalle){
        return pagoDetalleMapper.map(pagoDetalleRepository.findById(pagoDetalle), PagoDetalleDto.class);
    }

    //Obtener-todos-los-pago-detalle-del-alumno-----------------------------
    public List<PagoDetalleDto> getPagosAlumno(String alumno){
        return pagoDetalleRepository.findAllByAlumno(alumno)
                .stream().map(pagos -> pagoDetalleMapper.map(pagos, PagoDetalleDto.class))
                .collect(Collectors.toList());
    }

    //Obtener-total-monto-pagado-por-el-alumno-----------------------------
    public Double getTotalPago(String alumno){
        return this.getPagosAlumno(alumno).stream().mapToDouble(PagoDetalleDto::getMonto).sum();
    }
}
