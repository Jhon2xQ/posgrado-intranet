package com.sistema.intranet.controllers;

import com.sistema.intranet.services.myServices.GeneralService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final GeneralService generalService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("alumno", generalService.getInfoDashboard());
        return "dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }

    /*@GetMapping("/register")
    public String register() {
        return null;
    }*/
}

