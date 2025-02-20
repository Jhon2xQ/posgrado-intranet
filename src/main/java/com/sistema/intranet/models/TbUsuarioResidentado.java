package com.sistema.intranet.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter

@Table(name = "tbUsuarioResidentado", schema = "Seguridad")
public class TbUsuarioResidentado implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "usuario")
    private String usuario;

    @Column(name = "contraseña")
    private String contrasenia;

    @Column(name = "estado")
    private Boolean estado;
}
