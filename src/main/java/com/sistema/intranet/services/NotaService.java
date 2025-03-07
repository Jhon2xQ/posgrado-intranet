package com.sistema.intranet.services;

import com.sistema.intranet.models.TbNota;
import com.sistema.intranet.repositories.NotaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NotaService {
    private final NotaRepository notaRepository;

    public List<TbNota> getNotasUltimaCurricula(String alumno, String carrera, Integer curricula) {
        return notaRepository.findAllNotasByCurriculaActivas(alumno, carrera, "A", curricula);
    }
}
