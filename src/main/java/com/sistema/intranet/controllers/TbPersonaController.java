package com.sistema.intranet.controllers;

import com.sistema.intranet.dtos.PersonaDto;
import com.sistema.intranet.models.TbAlumno;
import com.sistema.intranet.models.TbAlumnoCarrera;
import com.sistema.intranet.models.TbPersona;
import com.sistema.intranet.services.AlumnoCarreraService;
import com.sistema.intranet.services.AlumnoService;
import com.sistema.intranet.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor

@RestController
@RequestMapping("/api")
public class TbPersonaController {

    private final PersonaService personaService;
    private final AlumnoCarreraService alumnoCarreraService;
    private final AlumnoService alumnoService;

    @CrossOrigin
    @GetMapping("/persona/{persona}")
    public PersonaDto getPersona(@PathVariable Integer persona) {
        return personaService.getPersona(persona);
    }

    @CrossOrigin
    @GetMapping("/carrera/{alumno}")
    public TbAlumnoCarrera getAlumnoCarrera(@PathVariable String alumno) {
        return alumnoCarreraService.getAlumnoCarrera(alumno);
    }

    @CrossOrigin
    @GetMapping("/alumno/{alumno}")
    public TbAlumno getAlumno(@PathVariable String alumno) {
        return alumnoService.getAlumno(alumno);
    }
}
