package com.sistema.intranet.dtos.paquetes;

import com.sistema.intranet.dtos.CurriculaCursoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NotasCompletoDto {
    private CurriculaCursoDto curso;
    private String semestre;
    private Double nota;
}
