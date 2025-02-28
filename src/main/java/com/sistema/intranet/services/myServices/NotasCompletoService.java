package com.sistema.intranet.services.myServices;

import com.sistema.intranet.dtos.paquetes.NotasCompletoDto;
import com.sistema.intranet.models.TbNota;
import com.sistema.intranet.repositories.NotaRepository;
import com.sistema.intranet.services.CurriculaCursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class NotasCompletoService {

    private final NotaRepository notaRepository;
    private final CurriculaCursoService curriculaCursoService;

    public List<NotasCompletoDto> getCompletoNotas(String alumno, String carrera) {
        return notaRepository.findNotasCompletasActivas(alumno, carrera, "A")
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
                                nota.getCurricula()),
                        nota.getSemestre(),
                        nota.getNota(),
                        nota.getTipoNota(),
                        nota.getResolucion(),
                        nota.getGrupo()
                )).collect(Collectors.toList());
    }

    public List<NotasCompletoDto> getNotasUltimaCurricula(String alumno, String carrera, Integer curricula) {
        return notaRepository.findAllNotasByCurriculaActivas(alumno, carrera, "A", curricula)
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
                                nota.getCurricula()),
                        nota.getSemestre(),
                        nota.getNota(),
                        nota.getTipoNota(),
                        nota.getResolucion(),
                        nota.getGrupo()
                )).collect(Collectors.toList());
    }
}
