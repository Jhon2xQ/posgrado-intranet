package com.sistema.intranet.dtos;

import lombok.Data;

@Data
public class AvisoDto {
    private String titulo;
    private String cuerpo;
    private String enlaceImagen;
    private String enlaceVerMas;
}
