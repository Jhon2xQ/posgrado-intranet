package com.sistema.intranet.controllers;

import com.sistema.intranet.dtos.paquetes.InformacionAlumnoDto;
import com.sistema.intranet.services.AvisosService;
import com.sistema.intranet.services.EnlacesService;
import com.sistema.intranet.services.myServices.AuthService;
import com.sistema.intranet.services.myServices.GeneralService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor

@SessionAttributes({"infoAlumno"})

public class AuthController {

    private final GeneralService generalService;
    private final AuthService authService;
    private final AvisosService avisosService;
    private final EnlacesService enlacesService;

    //Muestra login.html, dentro de este, hay un metodo POST para login.
    //Verifique userDetails/SecurityConfig.
    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        Model model,
                        Authentication authentication) {
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/dashboard";
        }
        if (error != null) {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
        }
        return "auth/login";
    }

    //Metodo get para register en caso lo hubiera.
    /* @GetMapping("/register")
    public String register() {
        return null;
    }*/

    //Muestra dashboard.html una vez realizado un login exitoso.
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        if (!model.containsAttribute("infoAlumno")) {                                  //Guardar info alumno en sesion (@SessionAttributes) y
            model.addAttribute("infoAlumno", generalService.getInformacionAlumno());   //Si hay cambios en la DB, cerrar cesion y volver a ingresar
        }
        model.addAttribute("aviso", avisosService.getAviso());                         //obtener aviso.
        model.addAttribute("enlaces", enlacesService.getEnlaces());                    //obtener enlaces externos.
        return "dashboard";
    }

    //muestra perfil.html
    @GetMapping("/perfil")
    public String perfil(Model model, @SessionAttribute("infoAlumno") InformacionAlumnoDto infoAlumno) {
        if (!model.containsAttribute("infoAlumno")) {
            model.addAttribute("infoAlumno", infoAlumno);                              //Obtener la info del alumno guardado en sesion.
        }
        return "perfil";
    }

    //Metodo post para guardar cambiar la contrasenia del alumno.
    @PostMapping("/cambiarContraseña")
    public String cambiarContrasenia(@RequestParam String password, HttpServletRequest request, RedirectAttributes redirectAttributes) {
        try {
            authService.cambiarContrasenia(password);                                              //cambiar contrasenia.
            // Invalidar sesión y cerrar sesión del usuario
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();  // Invalida la sesión actual
            }
            SecurityContextHolder.clearContext();  // Limpia la autenticación
            return "redirect:/login";
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return "redirect:/perfil";
        }
    }
}

