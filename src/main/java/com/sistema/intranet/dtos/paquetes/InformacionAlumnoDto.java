package com.sistema.intranet.dtos.paquetes;

import com.sistema.intranet.dtos.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class InformacionAlumnoDto {
    private String codigo;
    private PersonaDto persona;
    private CarreraDto carrera;
    private EspecialidadDto especialidad;
    private CurriculaDto curricula;
}
