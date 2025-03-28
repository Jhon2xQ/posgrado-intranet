package com.sistema.intranet.services.myServices;
import com.sistema.intranet.dtos.PersonaDto;
import com.sistema.intranet.dtos.paquetes.*;
import com.sistema.intranet.models.TbAlumnoCarrera;
import com.sistema.intranet.services.*;
import com.sistema.intranet.config.UserDetails.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GeneralService {
    private final PersonaService personaService;
    private final CarreraService carreraService;
    private final EspecialidadService especialidadService;
    private final PagosCompletoService pagosCompletoService;
    private final CurriculaService curriculaService;
    private final AlumnoCarreraService alumnoCarreraService;
    private final NotasCompletoService notasCompletoService;
    private final AuthService authService;

    /*=================================MÉTODOS=================================*/

    public PersonaDto getInfoPersona() {
        CustomUserDetails user = authService.getUsuarioAutenticado();
        return personaService.getPersona(user.getPersona());
    }

    //Obtener-datos-personales-para-la-interfaz-dashboard------------------------
    public DashboardDto getInfoDashboard(){
        CustomUserDetails user = authService.getUsuarioAutenticado();
        TbAlumnoCarrera alumnoCarrera = alumnoCarreraService.getAlumnoCarreraActivo(user.getUsername());
        return new DashboardDto(
                personaService.getPersona(user.getPersona()).getNombres(),
                carreraService.getCarrera(alumnoCarrera.getCarrera()).getNombre(),
                especialidadService.getEspecialidad(alumnoCarrera.getEspecialidad()).getDescripcion()
        );
    }

    //Obtener-datos-generales-para-la-interfaz-pagos-----------------------------
    public InformacionAlumnoDto getInformacionAlumno(){
        CustomUserDetails user = authService.getUsuarioAutenticado();
        TbAlumnoCarrera alumnoCarrera = alumnoCarreraService.getAlumnoCarreraActivo(user.getUsername());
        return new InformacionAlumnoDto(
                user.getUsername(),
                personaService.getPersona(user.getPersona()),
                carreraService.getCarrera(alumnoCarrera.getCarrera()),
                especialidadService.getEspecialidad(alumnoCarrera.getEspecialidad()),
                curriculaService.getCurricula(alumnoCarrera.getCurricula(), alumnoCarrera.getCarrera())
        );
    }

    public List<NotasCompletoDto> getNotasAlumnoUltimaCurricula(){
        CustomUserDetails user = authService.getUsuarioAutenticado();
        TbAlumnoCarrera alumnoCarrera = alumnoCarreraService.getAlumnoCarreraActivo(user.getUsername());
        return notasCompletoService.getNotasUltimaCurricula(
                user.getUsername(),
                alumnoCarrera.getCarrera(),
                alumnoCarrera.getCurricula()
        );
    }

    //Obtener-datos-generales-para-la-interfaz-pagos-----------------------------
    public PagosCompletoDto getPagosAlumno(){
        CustomUserDetails user = authService.getUsuarioAutenticado();
        TbAlumnoCarrera alumnoCarrera = alumnoCarreraService.getAlumnoCarreraActivo(user.getUsername());
        return pagosCompletoService.getPagosCompleto(user.getUsername(), alumnoCarrera.getMontoMaestria());
    }
}
