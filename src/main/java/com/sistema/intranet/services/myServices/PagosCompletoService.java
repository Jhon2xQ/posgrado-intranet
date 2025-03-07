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

    public PagosCompletoDto getPagosCompleto(String alumno, Double totalMaestria) {
        List<PagoDetalleDto> pagos = pagoDetalleService.getPagosAlumno(alumno);
        Double totalPagado = getTotal(pagos);
        return new PagosCompletoDto(pagos, new ResumenGPDto(totalMaestria, totalPagado, totalMaestria - totalPagado)
        );
    }

    public Double getTotal(List<PagoDetalleDto> pagos){
        return pagos.stream().mapToDouble(PagoDetalleDto::getMonto).sum();
    }
}
