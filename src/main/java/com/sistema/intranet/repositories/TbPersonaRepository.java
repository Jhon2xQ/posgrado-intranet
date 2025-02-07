package com.sistema.intranet.repositories;

import com.sistema.intranet.models.TbPersona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TbPersonaRepository extends JpaRepository<TbPersona, Void>, JpaSpecificationExecutor<TbPersona> {

}