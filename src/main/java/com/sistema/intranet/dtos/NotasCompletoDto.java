package com.sistema.intranet.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class NotasCompletoDto {
    private String curso;
    private String nombreCurso;
    private Double nota;
    private Integer creditos;
    private String categoria;
    private String fechaFin;
}
