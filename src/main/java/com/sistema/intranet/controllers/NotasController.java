package com.sistema.intranet.controllers;

import com.sistema.intranet.dtos.paquetes.NotasCompletoDto;
import com.sistema.intranet.dtos.paquetes.SeguimientoNotasDto;
import com.sistema.intranet.services.myServices.GeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Controller
@SessionAttributes({"reporte", "allNotas", "semestres"}) // Almacena en sesión la información del alumno y todas las notas
public class NotasController {

    private final GeneralService generalService;

    @GetMapping("/notas")
    public String mostrarInformacionAlumno(Model model) {
        if (!model.containsAttribute("reporte")) {
            SeguimientoNotasDto reporte = generalService.getInformacionAlumno();
            model.addAttribute("reporte", reporte);
        }
        if (!model.containsAttribute("allNotas")) {
            List<NotasCompletoDto> allNotas = generalService.getCompletoNotas();
            model.addAttribute("allNotas", allNotas);
            // Extraer los semestres únicos de las notas
            List<String> semestres = allNotas.stream()
                    .map(NotasCompletoDto::getSemestre)
                    .distinct()
                    .collect(Collectors.toList());
            model.addAttribute("semestres", semestres);
        }
        return "reporteNotas";
    }


    // Al enviar el formulario, se filtran las notas del semestre seleccionado a partir del conjunto almacenado
    @PostMapping("/notas")
    public String verNotasPorSemestre(@RequestParam("semestre") String semestre,
                                      Model model,
                                      @ModelAttribute("allNotas") List<NotasCompletoDto> allNotas) {
        if (semestre != null && !semestre.isEmpty()) {
            List<NotasCompletoDto> notas = allNotas.stream()
                    .filter(nota -> nota.getSemestre().equals(semestre))
                    .collect(Collectors.toList());
            model.addAttribute("notas", notas);
        } else {
            model.addAttribute("notas", null);
        }
        return "reporteNotas";
    }
}
