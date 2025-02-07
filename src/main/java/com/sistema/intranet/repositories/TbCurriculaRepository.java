package com.sistema.intranet.repositories;

import com.sistema.intranet.models.TbCurricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TbCurriculaRepository extends JpaRepository<TbCurricula, Void>, JpaSpecificationExecutor<TbCurricula> {

}