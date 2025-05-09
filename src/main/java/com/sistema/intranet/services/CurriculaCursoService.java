package com.sistema.intranet.services;

import com.sistema.intranet.dtos.CurriculaCursoDto;
import com.sistema.intranet.repositories.CurriculaCursoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class CurriculaCursoService {

    private final CurriculaCursoRepository curriculaCursoRepository;
    private final CursoService cursoService;
    private final ModelMapper curriculaCursoMapper;

    public CurriculaCursoDto getCurriculaCurso(String curso,
                                               String cursoAux,
                                               Integer curriculaAux,
                                               String semestre,
                                               String carrera,
                                               String especialidad,
                                               String grupo,
                                               Integer curricula,
                                               Date fechaFinalizacion) {
        CurriculaCursoDto curriculaCurso = curriculaCursoMapper.map(
                curriculaCursoRepository.findByCursoAndCarreraAndEspecialidadAndCurricula(curso, carrera, especialidad, curricula),
                CurriculaCursoDto.class
        );

        if (fechaFinalizacion == null) {
            curriculaCurso.setFechaFinalizacion(cursoService.getCurso(cursoAux, semestre, carrera, especialidad, grupo, curriculaAux)
                    .getFechaFinalizacion());
        }else {
            curriculaCurso.setFechaFinalizacion(fechaFinalizacion);
        }
        return curriculaCurso;
    }
}
