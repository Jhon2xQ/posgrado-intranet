package com.sistema.intranet.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class NotaDto {
    private CurriculaCursoDto curso;
    private String semestre;
    private Double nota;
    private String tipoNota;
    private String resolucion;
    private String grupo;
}
