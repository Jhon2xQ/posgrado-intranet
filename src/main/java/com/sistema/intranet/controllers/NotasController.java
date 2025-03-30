package com.sistema.intranet.controllers;

import com.sistema.intranet.dtos.NotaDto;
import com.sistema.intranet.dtos.paquetes.NotasCompletoDto;
import com.sistema.intranet.dtos.paquetes.InformacionAlumnoDto;
import com.sistema.intranet.services.myServices.GeneralService;
import com.sistema.intranet.services.myServices.NotasCompletoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@SessionAttributes({"infoAlumno", "allNotas"})
public class NotasController {

    private final GeneralService generalService;
    private final NotasCompletoService notasCompletoService;

    @GetMapping("/notas")
    public String mostrarInformacionAlumno(Model model, @SessionAttribute("infoAlumno") InformacionAlumnoDto infoAlumno) {

        if (!model.containsAttribute("allNotas")) {
            NotasCompletoDto allNotas = generalService.getNotasAlumno();
            model.addAttribute("allNotas", allNotas);
        }
        model.addAttribute("infoAlumno", infoAlumno);
        return "reporteNotas";
    }

    @PostMapping("/notas")
    public String verNotasPorSemestre(@RequestParam("semestre") String semestre, Model model,
                                      @SessionAttribute("allNotas") NotasCompletoDto allNotas) {
        if (semestre != null && !semestre.isEmpty()) {
            List<NotaDto> notas = notasCompletoService.filtrarNotasPorSemestre(allNotas.getNotas(), semestre);
            model.addAttribute("notas", notas);
            model.addAttribute("semestreSeleccionado", semestre);
        } else {
            model.addAttribute("notas", null);
            model.addAttribute("semestreSeleccionado", "");
        }
        return "reporteNotas";
    }
}
