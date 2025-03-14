package com.sistema.intranet.config.UserDetails;

import com.sistema.intranet.models.TbUsuarioResidentado;
import com.sistema.intranet.repositories.UsuarioResidentadoRepository;
import com.sistema.intranet.services.AlumnoService;
import com.sistema.intranet.services.UsuarioResidentadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class CustomUserDetailsService implements UserDetailsService{

    private final UsuarioResidentadoService usuarioResidentadoService;
    private final AlumnoService alumnoService;

    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        TbUsuarioResidentado usuarioResidentado = usuarioResidentadoService.getUsuarioResidentado(usuario);
        return new CustomUserDetails(
                        usuarioResidentado.getUsuario(),
                        usuarioResidentado.getContrasenia(),
                        usuarioResidentado.getRoles(),
                        alumnoService.getAlumno(usuario).getPersona()
        );
    }
}
