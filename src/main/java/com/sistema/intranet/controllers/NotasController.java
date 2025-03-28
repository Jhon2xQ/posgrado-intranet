package com.sistema.intranet.controllers;

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
@SessionAttributes({"infoAlumno", "allNotas", "semestres", "totalCreditos"}) // Almacena en sesión la información del alumno y todas las notas
public class NotasController {

    private final GeneralService generalService;
    private final NotasCompletoService notasCompletoService;

    @GetMapping("/notas")
    public String mostrarInformacionAlumno(Model model) {
        if (!model.containsAttribute("infoAlumno") && !model.containsAttribute("allNotas")) {
            InformacionAlumnoDto informacionAlumno = generalService.getInformacionAlumno();
            List<NotasCompletoDto> allNotas = generalService.getNotasAlumno();
            List<String> semestres = notasCompletoService.getSemestres(allNotas);
            Integer totalCreditos = notasCompletoService.totalCreditos(allNotas, informacionAlumno.getCurricula().getNotaAprobacion());

            model.addAttribute("allNotas", allNotas);
            model.addAttribute("semestres", semestres);
            model.addAttribute("totalCreditos", totalCreditos);
            model.addAttribute("infoAlumno", informacionAlumno);
        }
        return "reporteNotas";
    }

    @PostMapping("/notas")
    public String verNotasPorSemestre(@RequestParam("semestre") String semestre, Model model,
                                      @ModelAttribute("allNotas") List<NotasCompletoDto> allNotas) {
        if (semestre != null && !semestre.isEmpty()) {
            List<NotasCompletoDto> notas = notasCompletoService.filtrarNotasPorSemestre(allNotas, semestre);
            model.addAttribute("notas", notas);
            model.addAttribute("semestreSeleccionado", semestre);
        } else {
            model.addAttribute("notas", null);
            model.addAttribute("semestreSeleccionado", "");
        }
        return "reporteNotas";
    }
}
