package com.sistema.intranet.repositories;

import com.sistema.intranet.models.TbCarrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends JpaRepository<TbCarrera, String> {
}
