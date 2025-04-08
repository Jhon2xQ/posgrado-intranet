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

    /*=================================MÉTODOS=================================*/

    //Obtener-todas las notas del alumno: regular-homologacion-convalidacion-----------------------------
    public NotasCompletoDto getNotasCompleto(String codigo, String carrera, Integer curricula) {
        List<NotaDto> notasCompleto = this.getNotas(codigo, carrera, curricula);
        return new NotasCompletoDto(
                notasCompleto,                                              //total notas del alumno
                this.getSemestres(notasCompleto),                           //semestres totales
                this.getTotalCreditos(notasCompleto, curricula, carrera)    //total creditos
        );
    }

    //Obtener-todas las notas del alumno: regular-homologacion-convalidacion-----------------------------
    public List<NotaDto> getNotas(String alumno, String carrera, Integer curricula) {

        //Obtener notas tanto regulares como homologadas
        List<NotaDto> notasRegular = notaService.getNotas(alumno, carrera, curricula)   //buscar notas regulares/homologadas
                .stream().map(nota -> new NotaDto(
                        curriculaCursoService.getCurriculaCurso(                        //obtener datos del curso que está en CurriculaCurso
                                nota.getCurso(),                      //codigo curso actual
                                nota.getCursoAux(),                   //codigo curso antigua
                                nota.getCurriculaAux(),               //curricula del curso antiguo
                                nota.getSemestre(),                   //semestre que se llevo el curso
                                nota.getCarrera(),                    //carrera
                                nota.getEspecialidad(),               //especialidad
                                nota.getGrupo(),                      //grupo del curso
                                nota.getCurricula(),                  //curricula actual del curso
                                null),    //fecha captura
                        nota.getSemestre(),                           //semestre
                        nota.getNota(),                               //nota
                        nota.getTipoNota(),                           //tipo nota
                        nota.getResolucion(),                         //resolucion
                        nota.getGrupo())                              //grupo
                ).toList();

        //Obtener notas convalidacion: Misma estructura que 'notasRegular'.
        List<NotaDto> notasConvalidacion = convalidacionService.getNotasConvalidacionUltimaCurricula(alumno, carrera, curricula)
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

        //JUNTAR TODAS LAS NOTAS Y DEVOLVER.
        return Stream.concat(notasRegular.stream(), notasConvalidacion.stream()).collect(Collectors.toList());
    }

    //Obtener los semestre de notas del alumno.
    public List<String> getSemestres(List<NotaDto> notasCompleto) {
        return notasCompleto.stream().map(NotaDto::getSemestre).distinct().collect(Collectors.toList());
    }

    //Obtener total creditos acumulados
    public Integer getTotalCreditos(List<NotaDto> notasCompleto, Integer curricula, String carrera) {
        Double notaAprobacion = curriculaService.getCurricula(curricula, carrera).getNotaAprobacion();
        return notasCompleto.stream()
                .filter(notas -> notas.getNota() >= notaAprobacion)
                .mapToInt(notas -> notas.getCurso().getCreditos())
                .sum();
    }

    //Funcion que filtra las notas de un determinado semestre.
    public List<NotaDto> filtrarNotasPorSemestre(List<NotaDto> notasCompleto, String semestre) {
        return notasCompleto.stream()
                .filter(nota -> nota.getSemestre().equals(semestre))
                .collect(Collectors.toList());
    }
}
