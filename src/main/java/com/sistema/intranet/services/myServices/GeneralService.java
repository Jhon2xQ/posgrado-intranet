package com.sistema.intranet.services.myServices;
import com.sistema.intranet.dtos.paquetes.ReportePagosDto;
import com.sistema.intranet.dtos.paquetes.ResumenGPDto;
import com.sistema.intranet.models.TbAlumnoCarrera;
import com.sistema.intranet.services.*;
import com.sistema.intranet.services.myServices.UserDetails.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GeneralService {
    private final PersonaService personaService;
    private final CarreraService carreraService;
    private final EspecialidadService especialidadService;
    private final PagoDetalleService pagoDetalleService;
    private final CurriculaService curriculaService;
    private final AlumnoCarreraService alumnoCarreraService;
    private final AuthService authService;

    /*=================================MÉTODOS=================================*/

    //Obtener-datos-generales-para-la-interfaz-pagos-----------------------------
    public ReportePagosDto getReportePagos(){
        CustomUserDetails user = authService.getUsuarioAutenticado();
        return getReportePagosDetails(user.getUsername(), user.getPersona());
    }

    //Obtener-datos-generales-detallados-para-la-interfaz-pagos-------------------
    public ReportePagosDto getReportePagosDetails(String alumno, Integer persona){
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
