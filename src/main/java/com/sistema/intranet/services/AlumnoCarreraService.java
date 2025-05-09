package com.sistema.intranet.services;

import com.sistema.intranet.models.TbAlumnoCarrera;
import com.sistema.intranet.repositories.AlumnoCarreraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AlumnoCarreraService {

    private final AlumnoCarreraRepository alumnoCarreraRepository;

    /*=================================MÉTODOS=================================*/

    //Obtener-datos-generales-para-la-interfaz-pagos-----------------------------
    public TbAlumnoCarrera getAlumnoCarreraActivo(String alumno) {
        return alumnoCarreraRepository.findByAlumnoAndEstadoAlumnoNot(alumno, 5).orElseThrow(() -> new RuntimeException("Alumno desactivado"));
    }
}
