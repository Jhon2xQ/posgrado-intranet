package com.sistema.intranet.controllers;

import com.sistema.intranet.dtos.paquetes.NotasCompletoDto;
import com.sistema.intranet.services.myServices.NotasCompletoService;
import com.sistema.intranet.services.myServices.GeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PruebaController {
    private final GeneralService generalService;
    private final NotasCompletoService notasCompletoService;

    @GetMapping("/notas/{alumno}")
    public List<NotasCompletoDto> getNotas(@PathVariable String alumno) {
        return notasCompletoService.getNotas(alumno, "SC", "A");
    }
}
