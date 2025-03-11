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
@Getter
@Setter
@Entity

@Table(name = "tbResidentadoPerfil", schema = "Seguridad")
public class TbPerfilResidentado implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPerfil")
    private Integer idPerfil;

    @Column(name = "nombre")
    private String nombre;

    @ManyToMany(mappedBy = "roles")
    private Set<TbUsuarioResidentado> usuarios = new HashSet<>();
}
