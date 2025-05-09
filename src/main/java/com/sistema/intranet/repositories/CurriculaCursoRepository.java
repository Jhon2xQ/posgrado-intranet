package com.sistema.intranet.repositories;

import com.sistema.intranet.models.TbCurriculaCurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurriculaCursoRepository extends JpaRepository<TbCurriculaCurso, String> {
    Optional<TbCurriculaCurso> findByCursoAndCarreraAndEspecialidadAndCurricula(String curso, String carrera, String especialidad, Integer curricula);
}
