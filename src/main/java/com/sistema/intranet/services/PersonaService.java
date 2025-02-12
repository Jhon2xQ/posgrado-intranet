package com.sistema.intranet.services;

import com.sistema.intranet.dtos.PersonaDto;
import com.sistema.intranet.models.TbPersona;
import com.sistema.intranet.repositories.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;
    private final ModelMapper personaMapper;


    /*=================================MÉTODOS=================================*/

    //Obtener-datos-de-la-persona-----------------------------
    public PersonaDto getPersona(Integer persona) {
        return personaMapper.map(personaRepository.findById(persona), PersonaDto.class);
    }

}
