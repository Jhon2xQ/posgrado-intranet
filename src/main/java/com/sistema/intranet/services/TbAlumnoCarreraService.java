package com.sistema.intranet.services;

import com.sistema.intranet.models.IdClasses.TbAlumnoCarreraId;
import com.sistema.intranet.models.TbAlumnoCarrera;
import com.sistema.intranet.repositories.TbAlumnoCarreraRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.jdbc.Expectation;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class TbAlumnoCarreraService {
    private final TbAlumnoCarreraRepository tbAlumnoCarreraRepository;

    public TbAlumnoCarrera getAlumnoCarrera(String alumno) {
        return tbAlumnoCarreraRepository.findByAlumnoAndEstadoAlumno(alumno, 2).orElse(null);
    }
}
