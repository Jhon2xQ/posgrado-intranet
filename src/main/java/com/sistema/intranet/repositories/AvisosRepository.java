package com.sistema.intranet.repositories;

import com.sistema.intranet.models.TbResidentadoAvisos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AvisosRepository extends JpaRepository<TbResidentadoAvisos, Integer> {
    Optional<TbResidentadoAvisos> findFirstByEstado(Boolean estado);
}
