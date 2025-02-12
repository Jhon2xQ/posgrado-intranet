package com.sistema.intranet.controllers;

import com.sistema.intranet.models.TbAlumnoCarrera;
import com.sistema.intranet.models.TbPersona;
import com.sistema.intranet.services.TbAlumnoCarreraService;
import com.sistema.intranet.services.TbPersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api")
public class TbPersonaController {

    private final TbPersonaService tbPersonaService;
    private final TbAlumnoCarreraService tbAlumnoCarreraService;

    @CrossOrigin
    @GetMapping("/{persona}")
    public TbPersona getPersona(@PathVariable Integer persona) {
        return tbPersonaService.getPersona(persona);
    }

    @CrossOrigin
    @GetMapping("/carrera/{alumno}")
    public TbAlumnoCarrera getAlumnoCarrera(@PathVariable String alumno) {
        return tbAlumnoCarreraService.getAlumnoCarrera(alumno);
    }

}
