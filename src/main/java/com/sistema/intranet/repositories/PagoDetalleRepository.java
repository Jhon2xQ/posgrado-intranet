package com.sistema.intranet.repositories;

import com.sistema.intranet.models.TbNota;
import com.sistema.intranet.models.TbPagoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PagoDetalleRepository extends JpaRepository<TbPagoDetalle, String> {
    List<TbPagoDetalle> findAllByAlumno(String alumno);

    @Query(value =
        """
        SELECT recibo, alumno, semestre, monto, estado, fecha, lugarpago
        FROM [Academico_Maestria].[Caja].[tbPagoDetalle]
        WHERE alumno = :alumno
        """,
            nativeQuery = true)
    List<Object[]> buscarPagosAlumno(@Param("alumno") String alumno);
}
