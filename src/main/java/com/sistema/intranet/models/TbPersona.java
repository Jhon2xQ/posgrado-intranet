package com.sistema.intranet.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

@Table(name = "tbPersona", schema = "General")
public class TbPersona implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "persona")
    private Integer persona;

    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "nro_documento")
    private String nroDocumento;

    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;

    @Column(name = "e_mail")
    private String email;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;
}
