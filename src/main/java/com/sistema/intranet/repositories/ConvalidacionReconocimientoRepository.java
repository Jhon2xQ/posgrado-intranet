package com.sistema.intranet.repositories;

import com.sistema.intranet.models.TbConvalidacionReconocimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConvalidacionReconocimientoRepository extends JpaRepository<TbConvalidacionReconocimiento, String> {
    List<TbConvalidacionReconocimiento> findAllByAlumnoAndCarreraAndEstadoAndCurriculaGreaterThanEqual(String alumno, String carrera, String estado, Integer curriculaIsGreaterThan);
}
