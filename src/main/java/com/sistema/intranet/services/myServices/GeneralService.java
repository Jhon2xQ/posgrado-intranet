package com.sistema.intranet.services.myServices;

import com.sistema.intranet.dtos.paquetes.*;
import com.sistema.intranet.models.TbAlumnoCarrera;
import com.sistema.intranet.services.*;
import com.sistema.intranet.config.UserDetails.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    //Obtener-datos-generales-para-la-interfaz-pagos-----------------------------
    public InformacionAlumnoDto getInformacionAlumno(){
        CustomUserDetails user = authService.getUsuarioAutenticado();                                           //obtener usuario autenticado
        TbAlumnoCarrera alumnoCarrera = alumnoCarreraService.getAlumnoCarreraActivo(user.getUsername());        //buscar en tbAlumnoCarrera
        return new InformacionAlumnoDto(
                user.getUsername(),                                                                             //codigo de alumno
                personaService.getPersona(user.getPersona()),                                                   //datos personales
                carreraService.getCarrera(alumnoCarrera.getCarrera()),                                          //datos de carrera
                especialidadService.getEspecialidad(alumnoCarrera.getEspecialidad()),                           //datos de especialidad
                curriculaService.getCurricula(alumnoCarrera.getCurricula(), alumnoCarrera.getCarrera())         //datos de curricula
        );
    }

    //Obtener-datos-generales-para-la-interfaz-pagos-----------------------------
    public NotasCompletoDto getNotasAlumno(){
        CustomUserDetails user = authService.getUsuarioAutenticado();
        TbAlumnoCarrera alumnoCarrera = alumnoCarreraService.getAlumnoCarreraActivo(user.getUsername());
        return notasCompletoService.getNotasCompleto(
                user.getUsername(),
                alumnoCarrera.getCarrera(),
                alumnoCarrera.getCurricula()
        );
    }

    //Obtener-datos-generales-para-la-interfaz-pagos-----------------------------
    public PagosCompletoDto getPagosAlumno(){
        CustomUserDetails user = authService.getUsuarioAutenticado();
        TbAlumnoCarrera alumnoCarrera = alumnoCarreraService.getAlumnoCarreraActivo(user.getUsername());
        return pagosCompletoService.getPagosCompleto(
                user.getUsername(),
                alumnoCarrera.getMontoMaestria()
        );
    }
}
