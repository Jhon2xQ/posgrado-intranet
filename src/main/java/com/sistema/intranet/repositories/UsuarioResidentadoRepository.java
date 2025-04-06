package com.sistema.intranet.repositories;

import com.sistema.intranet.models.TbUsuarioResidentado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioResidentadoRepository extends JpaRepository<TbUsuarioResidentado, String> {
    Optional<TbUsuarioResidentado> findByUsuarioAndEstado(String usuario, Boolean estado);
}
