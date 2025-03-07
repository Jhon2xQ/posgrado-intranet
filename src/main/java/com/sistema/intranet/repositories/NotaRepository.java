package com.sistema.intranet.repositories;

import com.sistema.intranet.models.TbNota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotaRepository extends JpaRepository<TbNota, String> {

    @Query(value = """
        SELECT 
            N.id,
            N.alumno,
            N.estado,
            N.curso                              AS curso_aux, --para buscar en tbNota (fecha finalizacion)
            N.curricula                          as curricula_aux, --para buscar en tbNota (fecha finalizacion)
            COALESCE(H.curso_h, N.curso)         AS curso,
            N.semestre,
            COALESCE(H.carrera, N.carrera)         AS carrera,
            COALESCE(H.grupo_h, N.grupo)           AS grupo,
            COALESCE(H.curricula_h, N.curricula)   AS curricula,
            COALESCE(H.especialidad_h, N.especialidad) AS especialidad,
            CASE
                    WHEN H.alumno IS NOT NULL THEN 'H'
                    ELSE N.tipo_nota
                END AS tipo_nota,
            N.nota                                AS nota,
            H.resolucion
        
        FROM [Academico_Maestria].[Seguimiento].[tbNota] AS N
        LEFT JOIN [Academico_Maestria].[Seguimiento].[tbHomologacion] AS H
          ON N.alumno = H.alumno 
             AND N.curso = H.curso 
             AND N.carrera = H.carrera 
             AND N.especialidad = H.especialidad
        WHERE N.alumno = :alumno
          AND N.carrera  = :carrera
          AND ((H.alumno IS NULL AND N.estado = :estado) -- Sin homologación: se filtra por estado 'A'
                 OR
                H.alumno IS NOT NULL                     -- Con homologación: se toman los datos de H
              )
        order by semestre
        """, nativeQuery = true)
    List<TbNota> findNotasCompletasActivas(@Param("alumno") String alumno,
                                           @Param("carrera") String carrera,
                                           @Param("estado") String estado);


    @Query(value = """
        SELECT 
            N.id,
            N.alumno,
            N.estado,
            N.curso                              AS curso_aux, --para buscar en tbNota (fecha finalizacion)
            N.curricula                          as curricula_aux, --para buscar en tbNota (fecha finalizacion)
            COALESCE(H.curso_h, N.curso)         AS curso,
            N.semestre,
            COALESCE(H.carrera, N.carrera)         AS carrera,
            COALESCE(H.grupo_h, N.grupo)           AS grupo,
            COALESCE(H.curricula_h, N.curricula)   AS curricula,
            COALESCE(H.especialidad_h, N.especialidad) AS especialidad,
            CASE
                    WHEN H.alumno IS NOT NULL THEN 'H'
                    ELSE N.tipo_nota
                END AS tipo_nota,
            N.nota                                AS nota,
            H.resolucion
        
        FROM [Academico_Maestria].[Seguimiento].[tbNota] AS N
        LEFT JOIN [Academico_Maestria].[Seguimiento].[tbHomologacion] AS H
          ON N.alumno = H.alumno 
             AND N.curso = H.curso 
             AND N.carrera = H.carrera 
             AND N.especialidad = H.especialidad
        WHERE N.alumno = :alumno                                --obtener las notas del alumno X
          AND N.carrera  = :carrera                             --de la carrera Y
          AND COALESCE(H.curricula_h, N.curricula) = :curricula --obtiene los registros que estan con la curricula vigente 
          AND ((H.alumno IS NULL AND N.estado = :estado) -- Sin homologación: se filtra por estado 'A'
                 OR
                H.alumno IS NOT NULL                     -- Con homologación: se toman los datos de H
              )
        order by semestre
        """, nativeQuery = true)
    List<TbNota> findAllNotasByCurriculaActivas(@Param("alumno") String alumno,
                                                @Param("carrera") String carrera,
                                                @Param("estado") String estado,
                                                @Param("curricula") Integer curricula);
}
