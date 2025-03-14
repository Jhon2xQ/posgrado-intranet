package com.sistema.intranet.controllers;

import com.sistema.intranet.dtos.PersonaDto;
import com.sistema.intranet.dtos.paquetes.InformacionAlumnoDto;
import com.sistema.intranet.dtos.paquetes.NotasCompletoDto;
import com.sistema.intranet.services.myServices.AuthService;
import com.sistema.intranet.services.myServices.GeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor

@SessionAttributes("infoPersona")

public class AuthController {

    private final GeneralService generalService;
    private final AuthService authService;

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("alumno", generalService.getInfoDashboard());
        return "dashboard";
    }

    @GetMapping("/perfil")
    public String perfil(Model model) {
        if (!model.containsAttribute("infoPersona")) {
            PersonaDto infoPersona = generalService.getInfoPersona();
            model.addAttribute("infoPersona", infoPersona);
        }
        return "perfil";
    }

    @PostMapping("/cambiarContraseña")
    public String cambiarContrasenia(@RequestParam String password) {
        authService.cambiarContrasenia(password);
        return "redirect:/logout";
    }

    /*@GetMapping("/register")
    public String register() {
        return null;
    }*/
}

