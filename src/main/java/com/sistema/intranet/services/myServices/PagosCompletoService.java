package com.sistema.intranet.services.myServices;

import com.sistema.intranet.dtos.PagoDetalleDto;
import com.sistema.intranet.dtos.paquetes.PagosCompletoDto;
import com.sistema.intranet.dtos.paquetes.ResumenGPDto;
import com.sistema.intranet.services.PagoDetalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PagosCompletoService {
    private final PagoDetalleService pagoDetalleService;

    /*=================================MÉTODOS=================================*/

    //Obtener-todos-los-pagos-del-alumno-----------------------------
    public PagosCompletoDto getPagosCompleto(String alumno, Double totalMaestria) {
        List<PagoDetalleDto> allPagoDetalles = pagoDetalleService.getPagosAlumno(alumno);                         //Obtener todos los pagos del alumno.
        Double totalPagado = this.getTotal(allPagoDetalles);                                                      //Obtener el total pagado por el alumno.

        //Ordenar toda la informacion en el DTO PagosCompletoDto.
        return new PagosCompletoDto(allPagoDetalles, new ResumenGPDto(totalMaestria, totalPagado, totalMaestria - totalPagado));
    }

    //Obtener el total pagado de una lista de pagos.
    public Double getTotal(List<PagoDetalleDto> pagos){
        return pagos.stream().mapToDouble(PagoDetalleDto::getMonto).sum();
    }
}
