package com.sistema.intranet.dtos;

import lombok.Data;

@Data
public class PersonaDto {
    private Integer persona;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
}
