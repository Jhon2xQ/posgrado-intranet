package com.sistema.intranet.controllers;

import com.sistema.intranet.dtos.paquetes.InformacionAlumnoDto;
import com.sistema.intranet.dtos.paquetes.PagosCompletoDto;
import com.sistema.intranet.services.myServices.GeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@SessionAttributes({"infoAlumno", "allPagos"})

public class PagosController {
    private final GeneralService generalService;
    @GetMapping("/pagos")
    public String mostrarReportePagos(Model model) {
        if (!model.containsAttribute("infoAlumno")) {
            InformacionAlumnoDto informacionAlumno = generalService.getInformacionAlumno();
            model.addAttribute("infoAlumno", informacionAlumno);
        }
        if (!model.containsAttribute("allPagos")) {
            PagosCompletoDto allPagos = generalService.getPagosAlumno();
            model.addAttribute("allPagos", allPagos);
        }
        return "reportePagos";
    }
}
