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

    @GetMapping("/pagos")
    public String mostrarReportePagos(Model model) {
        ReportePagosDto reporte = generalPagosService.getReportePagos("202190", 1000);
        model.addAttribute("reporte", reporte);
        return "reportePagos";
    }
}
