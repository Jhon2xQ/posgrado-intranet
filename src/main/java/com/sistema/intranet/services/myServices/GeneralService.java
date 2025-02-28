package com.sistema.intranet.services.myServices;
import com.sistema.intranet.dtos.paquetes.*;
import com.sistema.intranet.models.TbAlumnoCarrera;
import com.sistema.intranet.services.*;
import com.sistema.intranet.services.myServices.UserDetails.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GeneralService {
    private final PersonaService personaService;
    private final CarreraService carreraService;
    private final EspecialidadService especialidadService;
    private final PagoDetalleService pagoDetalleService;
    private final CurriculaService curriculaService;
    private final AlumnoCarreraService alumnoCarreraService;
    private final NotasCompletoService notasCompletoService;
    private final AuthService authService;

    /*=================================MÉTODOS=================================*/

    //Obtener-datos-personales-para-la-interfaz-dashboard------------------------
    public DashboardDto getInfoAlumno(){
        CustomUserDetails user = authService.getUsuarioAutenticado();
        TbAlumnoCarrera alumnoCarrera = alumnoCarreraService.getAlumnoCarrera(user.getUsername());
        return new DashboardDto(
                personaService.getPersona(user.getPersona()).getNombres(),
                carreraService.getCarrera(alumnoCarrera.getCarrera()).getNombre(),
                especialidadService.getEspecialidad(alumnoCarrera.getEspecialidad()).getDescripcion()
        );
    }

    //Obtener-datos-generales-para-la-interfaz-pagos-----------------------------
    public SeguimientoPagosDto getSeguimientoPagos(){
        CustomUserDetails user = authService.getUsuarioAutenticado();
        return getSeguimientoPagosDetails(user.getUsername(), user.getPersona());
    }

    //Obtener-datos-generales-detallados-para-la-interfaz-pagos-------------------
    public SeguimientoPagosDto getSeguimientoPagosDetails(String alumno, Integer persona){
        TbAlumnoCarrera alumnoCarrera = alumnoCarreraService.getAlumnoCarrera(alumno);
        return new SeguimientoPagosDto(
                alumno,
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

    //Obtener-datos-generales-para-la-interfaz-pagos-----------------------------
    public SeguimientoNotasDto getInformacionAlumno(){
        CustomUserDetails user = authService.getUsuarioAutenticado();
        return getSeguimientoNotasDetails(user.getUsername(), user.getPersona());
    }

    //Obtener-datos-generales-detallados-para-la-interfaz-notas-------------------
    public SeguimientoNotasDto getSeguimientoNotasDetails(String alumno, Integer persona){
        TbAlumnoCarrera alumnoCarrera = alumnoCarreraService.getAlumnoCarrera(alumno);
        return new SeguimientoNotasDto(
                alumno,
                personaService.getPersona(persona),
                carreraService.getCarrera(alumnoCarrera.getCarrera()),
                especialidadService.getEspecialidad(alumnoCarrera.getEspecialidad()),
                curriculaService.getCurricula(alumnoCarrera.getCurricula(), alumnoCarrera.getCarrera())
        );
    }

    public List<NotasCompletoDto> getCompletoNotas(){
        CustomUserDetails user = authService.getUsuarioAutenticado();
        TbAlumnoCarrera alumnoCarrera = alumnoCarreraService.getAlumnoCarrera(user.getUsername());
        return notasCompletoService.getNotas(user.getUsername(), alumnoCarrera.getCarrera(), "A");
    }
}
