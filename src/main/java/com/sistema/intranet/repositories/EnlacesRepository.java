package com.sistema.intranet.repositories;

import com.sistema.intranet.IntranetApplication;
import com.sistema.intranet.models.TbResidentadoEnlaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnlacesRepository extends JpaRepository<TbResidentadoEnlaces, Integer> {
    List<TbResidentadoEnlaces> findAllByEstado(Boolean estado);
}
