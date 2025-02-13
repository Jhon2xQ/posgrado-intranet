package com.sistema.intranet.services.myServices;

import com.sistema.intranet.dtos.PagoDetalleDto;
import com.sistema.intranet.dtos.paquetes.ReportePagosDto;
import com.sistema.intranet.dtos.paquetes.ResumenGPDto;
import com.sistema.intranet.models.TbAlumnoCarrera;
import com.sistema.intranet.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GeneralPagosService {
    private final PersonaService personaService;
    private final CarreraService carreraService;
    private final EspecialidadService especialidadService;
    private final PagoDetalleService pagoDetalleService;
    private final CurriculaService curriculaService;
    private final AlumnoCarreraService alumnoCarreraService;

    public ReportePagosDto getReportePagos(String alumno, Integer persona){
        TbAlumnoCarrera alumnoCarrera = alumnoCarreraService.getAlumnoCarrera(alumno);
        return new ReportePagosDto(
                personaService.getPersona(persona),
                carreraService.getCarrera(alumnoCarrera.getCarrera()),
                especialidadService.getEspecialidad(alumnoCarrera.getEspecialidad()),
                curriculaService.getCurricula(alumnoCarrera.getCurricula(), alumnoCarrera.getCarrera()),
                pagoDetalleService.getPagosAlumno(alumno),
                new ResumenGPDto(
                        alumnoCarrera.getMontoMaestria(),
                        pagoDetalleService.getTotalPago(alumno)
                )
        );
    }
}
