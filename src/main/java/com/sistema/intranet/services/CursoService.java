package com.sistema.intranet.services;

import com.sistema.intranet.models.TbCurso;
import com.sistema.intranet.repositories.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CursoService {
    private final CursoRepository cursoRepository;

    public TbCurso getCurso(String curso,
                            String semestre,
                            String carrera,
                            String especialidad,
                            String grupo,
                            Integer curricula)
    {
        return cursoRepository.findByCursoAndSemestreAndCarreraAndEspecialidadAndGrupoAndCurricula(curso, semestre, carrera, especialidad, grupo, curricula)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }
}
