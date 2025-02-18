package com.sistema.intranet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String admin() {
        return "login";  // Página solo para administradores
    }

}

