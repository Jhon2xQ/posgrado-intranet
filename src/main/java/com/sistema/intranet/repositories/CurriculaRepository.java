package com.sistema.intranet.repositories;

import com.sistema.intranet.models.TbCurricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurriculaRepository extends JpaRepository<TbCurricula, Integer> {
    Optional<TbCurricula> findByCurriculaAndCarrera(Integer curricula, String carrera);

    Optional<TbCurricula> findTopByCarreraAndEstadoOrderByCurriculaDesc(String carrera, String estado);

    Optional<TbCurricula> findTopByNombreContainingIgnoreCaseAndCarreraAndEstadoOrderByCurriculaDesc(String nombre, String carrera, String estado);
}
