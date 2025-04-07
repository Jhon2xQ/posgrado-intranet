package com.sistema.intranet.services.myServices;

import com.sistema.intranet.dtos.CurriculaDto;
import com.sistema.intranet.dtos.NotaDto;
import com.sistema.intranet.dtos.paquetes.NotasCompletoDto;
import com.sistema.intranet.models.TbCurricula;
import com.sistema.intranet.services.ConvalidacionReconocimientoService;
import com.sistema.intranet.services.CurriculaCursoService;
import com.sistema.intranet.services.CurriculaService;
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
    private final CurriculaService curriculaService;
    private final ConvalidacionReconocimientoService convalidacionService;
    private final CurriculaCursoService curriculaCursoService;

    public NotasCompletoDto getNotasCompleto(String codigo, String carrera, Integer curricula) {
        List<NotaDto> notasCompleto = this.getNotas(codigo, carrera, curricula);
        return new NotasCompletoDto(
                notasCompleto,
                this.getSemestres(notasCompleto),
                this.getTotalCreditos(notasCompleto, curricula, carrera)
        );
    }

    public List<NotaDto> getNotas(String alumno, String carrera, Integer curricula) {

        List<NotaDto> notasRegular = notaService.getNotas(alumno, carrera, curricula)
                .stream().map(nota -> new NotaDto(
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

        List<NotaDto> notasConvalidacion = convalidacionService.getNotasConvalidacionUltimaCurricula(alumno, carrera)
                .stream().map(nota -> new NotaDto(
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

    public List<String> getSemestres(List<NotaDto> notasCompleto) {
        return notasCompleto.stream().map(NotaDto::getSemestre).distinct().collect(Collectors.toList());
    }

    public Integer getTotalCreditos(List<NotaDto> notasCompleto, Integer curricula, String carrera) {
        Double notaAprobacion = curriculaService.getCurricula(curricula, carrera).getNotaAprobacion();
        return notasCompleto.stream()
                .filter(notas -> notas.getNota() >= notaAprobacion)
                .mapToInt(notas -> notas.getCurso().getCreditos())
                .sum();
    }

    public List<NotaDto> filtrarNotasPorSemestre(List<NotaDto> notasCompleto, String semestre) {
        return notasCompleto.stream()
                .filter(nota -> nota.getSemestre().equals(semestre))
                .collect(Collectors.toList());
    }
}
