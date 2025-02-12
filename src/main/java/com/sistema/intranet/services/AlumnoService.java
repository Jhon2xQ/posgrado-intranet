package com.sistema.intranet.services;

import com.sistema.intranet.models.TbAlumno;
import com.sistema.intranet.repositories.AlumnoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;

    /*==============================MÉTODOS==============================*/

    //obtener datos del alumno
    public TbAlumno getAlumno(String alumno) {
        return alumnoRepository.findById(alumno).orElse(null);
    }
}
