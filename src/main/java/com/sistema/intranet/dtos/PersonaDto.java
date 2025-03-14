package com.sistema.intranet.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class PersonaDto {
    private Integer persona;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nroDocumento;
    private Date fechaNacimiento;
    private String email;
    private String direccion;
    private String telefono;
}
