package com.sistema.intranet.services;

import com.sistema.intranet.dtos.CurriculaDto;
import com.sistema.intranet.repositories.CurriculaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CurriculaService {

    private final CurriculaRepository curriculaRepository;
    private final ModelMapper curriculaMapper;

    /*=================================MÉTODOS=================================*/

    //Obtener-datos-de-la-curricula-----------------------------
    public CurriculaDto getCurricula(Integer curricula) {
        return curriculaMapper.map(curriculaRepository.findById(curricula), CurriculaDto.class);
    }
}
