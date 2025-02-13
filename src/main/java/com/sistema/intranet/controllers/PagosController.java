package com.sistema.intranet.controllers;

import com.sistema.intranet.dtos.paquetes.ReportePagosDto;
import com.sistema.intranet.services.AlumnoCarreraService;
import com.sistema.intranet.services.myServices.GeneralPagosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/pagos")
public class PagosController {
    private final GeneralPagosService generalPagosService;

    @CrossOrigin
    @GetMapping("/{alumno}/{persona}")
    public ReportePagosDto getReportePagos(@PathVariable String alumno, @PathVariable Integer persona) {
        return generalPagosService.getReportePagos(alumno, persona);
    }
}
