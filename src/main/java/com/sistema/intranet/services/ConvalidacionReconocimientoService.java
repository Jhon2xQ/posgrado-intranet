package com.sistema.intranet.services;

import com.sistema.intranet.models.TbConvalidacionReconocimiento;
import com.sistema.intranet.repositories.ConvalidacionReconocimientoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ConvalidacionReconocimientoService {

    private final ConvalidacionReconocimientoRepository convalidacionRepository;

    public List<TbConvalidacionReconocimiento> getNotasConvalidacionUltimaCurricula(String alumno, String carrera, Integer curricula){
        return convalidacionRepository.findAllByAlumnoAndCarreraAndEstadoAndCurriculaGreaterThanEqual(alumno, carrera, "A", curricula);
    }
}
