package com.sistema.intranet.controllers;

import com.sistema.intranet.dtos.PersonaDto;
import com.sistema.intranet.dtos.paquetes.InformacionPagosDto;
import com.sistema.intranet.services.AlumnoCarreraService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/pagos")
public class PagosController {
    private final AlumnoCarreraService alumnoCarreraService;

    @CrossOrigin
    @GetMapping("/{alumno}")
    public InformacionPagosDto getPagos(@PathVariable String alumno) {
        return alumnoCarreraService.getInformacionPagos(alumno);
    }
}
