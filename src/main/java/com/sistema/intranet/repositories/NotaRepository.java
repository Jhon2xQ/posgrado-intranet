package com.sistema.intranet.repositories;

import com.sistema.intranet.models.TbNota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<TbNota, String> {
    List<TbNota> findAllByAlumnoAndEstado(String alumno, String estado);
}
