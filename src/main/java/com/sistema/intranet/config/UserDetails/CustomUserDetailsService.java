package com.sistema.intranet.config.UserDetails;

import com.sistema.intranet.repositories.UsuarioResidentadoRepository;
import com.sistema.intranet.services.AlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class CustomUserDetailsService implements UserDetailsService{

    private final UsuarioResidentadoRepository usuarioResidentadoRepository;
    private final AlumnoService alumnoService;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        return usuarioResidentadoRepository.findById(usuario)
                .map(userResidentado -> new CustomUserDetails(
                        userResidentado.getUsuario(),
                        userResidentado.getContrasenia(),
                        userResidentado.getRoles(),
                        alumnoService.getAlumno(usuario).getPersona()
                )).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
