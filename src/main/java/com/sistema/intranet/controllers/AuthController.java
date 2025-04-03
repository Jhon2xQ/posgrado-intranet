package com.sistema.intranet.controllers;

import com.sistema.intranet.dtos.paquetes.InformacionAlumnoDto;
import com.sistema.intranet.services.myServices.AuthService;
import com.sistema.intranet.services.myServices.GeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor

@SessionAttributes("infoAlumno")

public class AuthController {

    private final GeneralService generalService;
    private final AuthService authService;

    @GetMapping("/login")
    public String login(Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/dashboard";
        }
        return "auth/login";
    }

    /* @GetMapping("/register")
    public String register() {
        return null;
    }*/

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        if (!model.containsAttribute("infoAlumno")) {
            model.addAttribute("infoAlumno", generalService.getInformacionAlumno());
        }
        return "dashboard";
    }

    @GetMapping("/perfil")
    public String perfil(Model model, @SessionAttribute("infoAlumno") InformacionAlumnoDto infoAlumno) {
        if (!model.containsAttribute("infoAlumno")) {
            model.addAttribute("infoAlumno", infoAlumno);
        }
        return "perfil";
    }

    @PostMapping("/cambiarContraseña")
    public String cambiarContrasenia(@RequestParam String password, RedirectAttributes redirectAttributes) {
        try {
            authService.cambiarContrasenia(password);
            return "redirect:/logout";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/perfil";
        }
    }
}

