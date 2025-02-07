package com.sistema.intranet.repositories;

import com.sistema.intranet.models.TbPagoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TbPagoDetalleRepository extends JpaRepository<TbPagoDetalle, Void>, JpaSpecificationExecutor<TbPagoDetalle> {

}