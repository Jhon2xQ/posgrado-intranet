package com.sistema.intranet.services;

import com.sistema.intranet.dtos.*;
import com.sistema.intranet.dtos.paquetes.InformacionPagosDto;
import com.sistema.intranet.models.TbAlumnoCarrera;
import com.sistema.intranet.repositories.AlumnoCarreraRepository;
import com.sistema.intranet.repositories.AlumnoRepository;
import com.sistema.intranet.repositories.CurriculaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AlumnoCarreraService {
    private final AlumnoCarreraRepository alumnoCarreraRepo;
    private final AlumnoRepository alumnoRepo;
    private final CurriculaRepository curriculaRepo;
    private final ModelMapper personaMapper;
    private final ModelMapper carreraMapper;
    private final ModelMapper especialidadMapper;
    private final ModelMapper curriculaMapper;
    private final ModelMapper pagoDetalleMapper;

    /*=================================MÉTODOS=================================*/

    //Obtener-datos-generales-para-la-interfaz-pagos-----------------------------
    public InformacionPagosDto getInformacionPagos(String alumno) {
        return alumnoCarreraRepo.findByAlumnoAndEstadoAlumno(alumnoRepo.findById(alumno).orElse(null), 2)
                .map(alumnoCarrera -> {
                    PersonaDto personaDto = personaMapper.map(alumnoCarrera.getAlumno().getPersona(), PersonaDto.class);
                    CarreraDto carreraDto = carreraMapper.map(alumnoCarrera.getCarrera(), CarreraDto.class);
                    EspecialidadDto especialidadDto = especialidadMapper.map(alumnoCarrera.getEspecialidad(), EspecialidadDto.class);
                    List<PagoDetalleDto> pagoDetalleDtos = alumnoCarrera.getAlumno().getPagoDetalles().stream().map(
                            pagoDetalles -> pagoDetalleMapper.map(pagoDetalles, PagoDetalleDto.class)
                    ).collect(Collectors.toList());
                    return new InformacionPagosDto(personaDto, carreraDto, especialidadDto, pagoDetalleDtos);
                })
                .orElseThrow(() -> new RuntimeException("Alumno desactivado"));
    }


    public TbAlumnoCarrera getAlumnoCarrera(String alumno) {
        return alumnoCarreraRepo.findByAlumnoAndEstadoAlumno(alumnoRepo.findById(alumno).orElse(null), 2).orElse(null);
    }
}
