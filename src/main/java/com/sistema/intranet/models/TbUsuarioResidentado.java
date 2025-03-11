package com.sistema.intranet.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter

@Table(name = "tbResidentadoUsuario", schema = "Seguridad")
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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tbResidentadoUsuarioPerfil",
            schema = "Seguridad",
            joinColumns = @JoinColumn(name = "usuario"),
            inverseJoinColumns = @JoinColumn(name = "idPerfil")
    )
    private Set<TbPerfilResidentado> roles = new HashSet<>();
}
