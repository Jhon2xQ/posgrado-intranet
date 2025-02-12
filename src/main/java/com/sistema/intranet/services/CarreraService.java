package com.sistema.intranet.services;

import com.sistema.intranet.dtos.CarreraDto;
import com.sistema.intranet.repositories.CarreraRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CarreraService {

    private final CarreraRepository carreraRepository;
    private final ModelMapper carreraMapper;

    /*=================================MÉTODOS=================================*/

    //Obtener-datos-de-la-carrera-----------------------------
    public CarreraDto getCarrera(String carrera) {
        return carreraMapper.map(carreraRepository.findById(carrera), CarreraDto.class);
    }
}
