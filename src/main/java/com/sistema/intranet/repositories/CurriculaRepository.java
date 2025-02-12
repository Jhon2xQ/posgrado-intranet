package com.sistema.intranet.repositories;

import com.sistema.intranet.models.TbCurricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculaRepository extends JpaRepository<TbCurricula, Integer> {
}
