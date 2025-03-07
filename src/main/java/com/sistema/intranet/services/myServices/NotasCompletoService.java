package com.sistema.intranet.services.myServices;

import com.sistema.intranet.dtos.paquetes.NotasCompletoDto;
import com.sistema.intranet.services.ConvalidacionReconocimientoService;
import com.sistema.intranet.services.CurriculaCursoService;
import com.sistema.intranet.services.NotaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class NotasCompletoService {

    private final NotaService notaService;
    private final ConvalidacionReconocimientoService convalidacionService;
    private final CurriculaCursoService curriculaCursoService;


    public List<NotasCompletoDto> getNotasUltimaCurricula(String alumno, String carrera, Integer curricula) {

        List<NotasCompletoDto> notasRegular = notaService.getNotasUltimaCurricula(alumno, carrera, curricula)
                .stream().map(nota -> new NotasCompletoDto(
                        //obtener datos del curso que está en CurriculaCurso
                        curriculaCursoService.getCurriculaCurso(
                                nota.getCurso(),
                                nota.getCursoAux(),
                                nota.getCurriculaAux(),
                                nota.getSemestre(),
                                nota.getCarrera(),
                                nota.getEspecialidad(),
                                nota.getGrupo(),
                                nota.getCurricula(),
                                null),
                        nota.getSemestre(),
                        nota.getNota(),
                        nota.getTipoNota(),
                        nota.getResolucion(),
                        nota.getGrupo())
                ).toList();

        List<NotasCompletoDto> notasConvalidacion = convalidacionService.getNotasConvalidacionUltimaCurricula(alumno, carrera, curricula)
                .stream().map(nota -> new NotasCompletoDto(
                        //obtener datos del curso que está en CurriculaCurso
                        curriculaCursoService.getCurriculaCurso(
                                nota.getCurso(),
                                null,
                                null,
                                nota.getSemestre(),
                                nota.getCarrera(),
                                nota.getEspecialidad(),
                                null,
                                nota.getCurricula(),
                                nota.getFechaCaptura()),
                        nota.getSemestre(),
                        nota.getNota(),
                        nota.getTipoNota(),
                        nota.getResolucion(),
                        "")
                ).toList();

        return Stream.concat(notasRegular.stream(), notasConvalidacion.stream()).collect(Collectors.toList());
    }

    public List<NotasCompletoDto> filtrarNotasPorSemestre(List<NotasCompletoDto> notasCompleto, String semestre) {
        return notasCompleto.stream()
                .filter(nota -> nota.getSemestre().equals(semestre))
                .collect(Collectors.toList());
    }

    public List<String> getSemestres(List<NotasCompletoDto> notasCompleto) {
        return notasCompleto.stream().map(NotasCompletoDto::getSemestre).distinct().collect(Collectors.toList());
    }

    public Integer totalCreditos(List<NotasCompletoDto> notasCompleto, Double notaAprobacion) {
        return notasCompleto.stream()
                .filter(notas -> notas.getNota() >= notaAprobacion)
                .mapToInt(notas -> notas.getCurso().getCreditos())
                .sum();
    }
}
