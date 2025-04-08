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
@SessionAttributes({"infoAlumno", "allNotas"})                                                           //Guardar info en Cache. Si hay cambios en la DB. Cerrar Sesion e ingresar de nuevo.
public class NotasController {

    private final GeneralService generalService;
    private final NotasCompletoService notasCompletoService;

    @GetMapping("/notas")
    public String mostrarInformacionAlumno(Model model, @SessionAttribute("infoAlumno") InformacionAlumnoDto infoAlumno) {

        if (!model.containsAttribute("allNotas")) {                                          //SI no esta guardado en cache.
            NotasCompletoDto allNotas = generalService.getNotasAlumno();                                 //Obtener notas
            model.addAttribute("allNotas", allNotas);                                        //enviar al formulario
        }
        model.addAttribute("infoAlumno", infoAlumno);                                        //obtener y enviar datos guardados en cache de info Alumno.
        return "reporteNotas";
    }

    @PostMapping("/notas")
    public String verNotasPorSemestre(@RequestParam("semestre") String semestre, Model model,             //Obtener datos del post
                                      @SessionAttribute("allNotas") NotasCompletoDto allNotas) {
        if (semestre != null && !semestre.isEmpty()) {
            List<NotaDto> notas = notasCompletoService.filtrarNotasPorSemestre(allNotas.getNotas(), semestre);  //filtramos notas guadadas en Session(cache) al semestre elegido.
            model.addAttribute("notas", notas);                                                     //enviamos las notas filtradas al html .
            model.addAttribute("semestreSeleccionado", semestre);                                   //enviamos el semestre seleccionado.
        } else {
            model.addAttribute("notas", null);
            model.addAttribute("semestreSeleccionado", "");
        }
        return "reporteNotas";
    }
}
