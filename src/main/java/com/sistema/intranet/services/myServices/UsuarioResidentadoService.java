package com.sistema.intranet.services.myServices;

import com.sistema.intranet.repositories.UsuarioResidentadoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UsuarioResidentadoService implements UserDetailsService{

    private final UsuarioResidentadoRepository usuarioResidentadoRepository;

    @Override
    public UserDetails loadUserByUsername(String codigo) throws UsernameNotFoundException {

        return usuarioResidentadoRepository.findById(codigo)
                .map(usuario -> User.builder()
                        .username(usuario.getCodigo())
                        .password(usuario.getContrasenia())
                        .build())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
