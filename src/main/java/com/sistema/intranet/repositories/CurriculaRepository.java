package com.sistema.intranet.repositories;

import com.sistema.intranet.models.TbCurricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurriculaRepository extends JpaRepository<TbCurricula, Integer> {
    Optional<TbCurricula> findByCurriculaAndCarrera(Integer curricula, String carrera);
}
