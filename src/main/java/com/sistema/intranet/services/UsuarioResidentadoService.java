package com.sistema.intranet.services;

import com.sistema.intranet.models.TbUsuarioResidentado;
import com.sistema.intranet.repositories.UsuarioResidentadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioResidentadoService {
    private final UsuarioResidentadoRepository usuarioResidentadoRepository;

    public TbUsuarioResidentado getUsuarioResidentado(String usuario){
        return usuarioResidentadoRepository.findById(usuario).orElseThrow(() -> new RuntimeException("Credenciales no encontradas."));
    }

    public void cambiarContrasenia(String usuario, String nuevaContrasenia) {
        TbUsuarioResidentado usuarioResidentado = this.getUsuarioResidentado(usuario);
        usuarioResidentado.setContrasenia(nuevaContrasenia);
        usuarioResidentadoRepository.save(usuarioResidentado);
    }
}
