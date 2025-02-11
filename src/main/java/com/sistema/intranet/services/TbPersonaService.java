package com.sistema.intranet.services;

import com.sistema.intranet.models.TbPersona;
import com.sistema.intranet.repositories.TbPersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TbPersonaService {

    @Autowired
    private TbPersonaRepository tbPersonaRepository;

    public List<TbPersona> getPersonas() {
        return tbPersonaRepository.findAll();
    }

    public TbPersona getPersona(Integer persona) {
        TbPersona personaEncontrada = tbPersonaRepository.findById(persona).orElse(null);
        System.out.println("🔍 Persona encontrada: " + personaEncontrada);
        return personaEncontrada;
    }
}
