package com.sistema.intranet.repositories;

import com.sistema.intranet.models.TbPagoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PagoDetalleRepository extends JpaRepository<TbPagoDetalle, String> {
    List<TbPagoDetalle> findAllByAlumno(String alumno);
}
