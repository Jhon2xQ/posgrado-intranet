package com.sistema.intranet.controllers;

import com.sistema.intranet.dtos.paquetes.ReportePagosDto;
import com.sistema.intranet.services.myServices.GeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class PagosController {
    private final GeneralService generalService;

    @GetMapping("/pagos")
    public String mostrarReportePagos(Model model) {
        ReportePagosDto reporte = generalService.getReportePagos();
        model.addAttribute("reporte", reporte);
        return "reportePagos";
    }
}
