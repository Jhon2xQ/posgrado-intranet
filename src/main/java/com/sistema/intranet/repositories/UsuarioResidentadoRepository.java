package com.sistema.intranet.repositories;

import com.sistema.intranet.models.TbUsuarioResidentado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioResidentadoRepository extends JpaRepository<TbUsuarioResidentado, String> {
}
