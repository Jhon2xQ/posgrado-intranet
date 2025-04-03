package com.sistema.intranet.services;

import com.sistema.intranet.models.TbUsuarioResidentado;
import com.sistema.intranet.repositories.UsuarioResidentadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
public class UsuarioResidentadoService {
    private final UsuarioResidentadoRepository usuarioResidentadoRepository;

    public TbUsuarioResidentado getUsuarioResidentado(String usuario){
        return usuarioResidentadoRepository.findById(usuario).orElseThrow(() -> new RuntimeException("Credenciales no encontradas."));
    }

    public void cambiarContrasenia(String usuario, String nuevaContrasenia) {
        TbUsuarioResidentado usuarioResidentado = this.getUsuarioResidentado(usuario);

        LocalDateTime ultimaActualizacion = usuarioResidentado.getUltimoCambioContrasenia();
        if (ultimaActualizacion != null && ChronoUnit.MONTHS.between(ultimaActualizacion, LocalDateTime.now()) < 6) {
            throw new RuntimeException("La contraseña ya fue cambiada.");
        }

        usuarioResidentado.setContrasenia(nuevaContrasenia);
        usuarioResidentado.setUltimoCambioContrasenia(LocalDateTime.now());
        usuarioResidentadoRepository.save(usuarioResidentado);
    }
}
