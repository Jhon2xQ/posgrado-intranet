package com.sistema.intranet.controllers;

import com.sistema.intranet.models.TbPersona;
import com.sistema.intranet.services.TbPersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personas")
public class TbPersonaController {

    @Autowired
    private TbPersonaService tbPersonaService;

    @GetMapping()
    public List<TbPersona> getPersonas() {
        return tbPersonaService.getPersonas();
    }

    @CrossOrigin
    @GetMapping("/{persona}")
    public TbPersona getPersona(@PathVariable Integer persona) {
        return tbPersonaService.getPersona(persona);
    }

}
