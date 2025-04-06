package com.sistema.intranet.services;

import com.sistema.intranet.dtos.AvisoDto;
import com.sistema.intranet.dtos.EnlaceDto;
import com.sistema.intranet.repositories.AvisosRepository;
import com.sistema.intranet.repositories.EnlacesRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service

public class EnlacesService {

    private final EnlacesRepository enlacesRepository;
    private final ModelMapper enlaceMapper;

    /*=================================MÉTODOS=================================*/

    //Obtener-el primer aviso activo-----------------------------
    public List<EnlaceDto> getEnlaces() {
        return enlacesRepository.findAllByEstado(true).stream().map(
                enlace -> enlaceMapper.map(enlace, EnlaceDto.class)
        ).collect(Collectors.toList());
    }
}
