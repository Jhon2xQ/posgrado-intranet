package com.sistema.intranet.services.myServices;

import com.sistema.intranet.config.UserDetails.CustomUserDetails;
import com.sistema.intranet.config.UserDetails.CustomUserDetailsService;
import com.sistema.intranet.services.UsuarioResidentadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioResidentadoService usuarioResidentadoService;
    private final PasswordEncoder passwordEncoder;

    public CustomUserDetails getUsuarioAutenticado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof CustomUserDetails) {
            return (CustomUserDetails) authentication.getPrincipal();
        }
        throw new RuntimeException("no hay usuario autenticado");
    }

    public void cambiarContrasenia(String nuevaContrasenia) {
        usuarioResidentadoService.cambiarContrasenia(
                this.getUsuarioAutenticado().getUsername(),
                passwordEncoder.encode(nuevaContrasenia)
        );
    }
}
