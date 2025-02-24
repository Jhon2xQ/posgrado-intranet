package com.sistema.intranet.dtos.paquetes;

import com.sistema.intranet.dtos.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class SeguimientoNotasDto {
    private String codigo;
    private PersonaDto persona;
    private CarreraDto carrera;
    private EspecialidadDto especialidad;
    private CurriculaDto curricula;
}
