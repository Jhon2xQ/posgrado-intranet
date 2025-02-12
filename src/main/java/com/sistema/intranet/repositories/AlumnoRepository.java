package com.sistema.intranet.repositories;

import com.sistema.intranet.models.TbAlumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<TbAlumno, String> {
}
