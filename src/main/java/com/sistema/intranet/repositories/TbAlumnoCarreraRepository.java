package com.sistema.intranet.repositories;

import com.sistema.intranet.models.IdClasses.TbAlumnoCarreraId;
import com.sistema.intranet.models.TbAlumnoCarrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbAlumnoCarreraRepository extends JpaRepository<TbAlumnoCarrera, TbAlumnoCarreraId> {
}
