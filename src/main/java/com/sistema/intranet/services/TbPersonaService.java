package com.sistema.intranet.services;

import com.sistema.intranet.models.TbPersona;
import com.sistema.intranet.repositories.TbPersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor

@Service
public class TbPersonaService {

    private final TbPersonaRepository tbPersonaRepository;


    /*=================================MÉTODOS=================================*/

    /*--------Obtener la entidad persona buscando por su id---------*/

    public TbPersona getPersona(Integer persona) {
        return tbPersonaRepository.findById(persona).orElse(null);
    }

}
