package com.sistema.intranet.controllers;

import com.sistema.intranet.dtos.paquetes.ReportePagosDto;
import com.sistema.intranet.services.myServices.GeneralPagosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class PagosController {
    private final GeneralPagosService generalPagosService;

    @GetMapping("/pagos/{alumno}/{persona}")
    public String mostrarReportePagos(@PathVariable String alumno, @PathVariable Integer persona, Model model) {
        ReportePagosDto reporte = generalPagosService.getReportePagos(alumno, persona);
        model.addAttribute("reporte", reporte);
        return "reportePagos"; // Nombre del archivo HTML en "src/main/resources/templates/"
    }
}
