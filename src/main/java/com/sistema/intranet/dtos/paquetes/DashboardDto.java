package com.sistema.intranet.dtos.paquetes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class DashboardDto {
    private String nombreAlumno;
    private String carrera;
    private String especialidad;
}
