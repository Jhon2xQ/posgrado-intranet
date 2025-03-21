package com.sistema.intranet.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class CustomErrorController implements ErrorController {
    @GetMapping("/error")
    public void handleError(@AuthenticationPrincipal UserDetails userDetails, HttpServletRequest request, HttpServletResponse response) throws IOException {
        int statusCode = response.getStatus();

        if (statusCode == 404) { // Página no encontrada
            if (userDetails != null) {
                response.sendRedirect("/dashboard"); // Redirigir si está autenticado
            } else {
                response.sendRedirect("/login"); // Si no está autenticado, ir a login
            }
        }
    }
}
