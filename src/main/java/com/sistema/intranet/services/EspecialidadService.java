package com.sistema.intranet.services;

import com.sistema.intranet.dtos.EspecialidadDto;
import com.sistema.intranet.repositories.EspecialidadRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EspecialidadService {

    private final EspecialidadRepository especialidadRepository;
    private final ModelMapper carreraMapper;

    /*=================================MÉTODOS=================================*/

    //Obtener-datos-de-la-especialidad-----------------------------
    public EspecialidadDto getEspecialidad(String especialidad){
        return carreraMapper.map(especialidadRepository.findById(especialidad), EspecialidadDto.class);
    }
}
