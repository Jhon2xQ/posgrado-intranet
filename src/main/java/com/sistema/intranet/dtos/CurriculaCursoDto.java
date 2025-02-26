package com.sistema.intranet.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CurriculaCursoDto {
    private String curso;
    private String nombre;
    private String categoria;
    private Integer creditos;
    private Date fechaFinalizacion;
}
