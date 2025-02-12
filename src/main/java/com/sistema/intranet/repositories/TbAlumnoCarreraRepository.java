package com.sistema.intranet.repositories;

import com.sistema.intranet.models.IdClasses.TbAlumnoCarreraId;
import com.sistema.intranet.models.TbAlumno;
import com.sistema.intranet.models.TbAlumnoCarrera;
import com.sistema.intranet.models.TbCarrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TbAlumnoCarreraRepository extends JpaRepository<TbAlumnoCarrera, TbAlumnoCarreraId> {
    Optional<TbAlumnoCarrera> findByAlumnoAndEstadoAlumno(String alumno, Integer estadoAlumno);
}
