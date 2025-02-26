package com.sistema.intranet.controllers;

import com.sistema.intranet.dtos.paquetes.DetalleNotasDto;
import com.sistema.intranet.dtos.paquetes.SeguimientoNotasDto;
import com.sistema.intranet.dtos.paquetes.SeguimientoPagosDto;
import com.sistema.intranet.services.myServices.GeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class NotasController {

    private final GeneralService generalService;

    @GetMapping("/notas")
    public String mostrarReporteNotas(Model model) {
        SeguimientoNotasDto reporte = generalService.getSeguimientoNotas();
        model.addAttribute("reporte", reporte);
        return "reporteNotas";
    }

    /*@GetMapping("/notas/{semestre}")
    public String getNotasSemestre(Model model, @PathVariable String semestre){
        DetalleNotasDto notas = null;
        model.addAttribute("notas", notas);

    }*/
}
