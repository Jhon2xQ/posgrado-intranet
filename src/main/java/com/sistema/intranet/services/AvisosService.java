package com.sistema.intranet.services;

import com.sistema.intranet.dtos.AvisoDto;
import com.sistema.intranet.repositories.AvisosRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AvisosService {

    private final AvisosRepository avisosRepository;
    private final ModelMapper avisoMapper;

    /*=================================MÉTODOS=================================*/

    //Obtener-el primer aviso activo-----------------------------
    public AvisoDto getAviso() {
        return avisoMapper.map(avisosRepository.findFirstByEstado(true), AvisoDto.class);
    }
}
