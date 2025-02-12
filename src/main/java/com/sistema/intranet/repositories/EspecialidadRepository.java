package com.sistema.intranet.repositories;

import com.sistema.intranet.models.TbEspecialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<TbEspecialidad, String> {
}
