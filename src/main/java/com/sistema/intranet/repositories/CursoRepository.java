package com.sistema.intranet.repositories;

import com.sistema.intranet.models.TbCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<TbCurso, String> {
    Optional<TbCurso> findByCursoAndSemestreAndCarreraAndEspecialidadAndGrupoAndCurricula(String curso, String semestre, String carrera, String especialidad, String grupo, Integer curricula);
}
