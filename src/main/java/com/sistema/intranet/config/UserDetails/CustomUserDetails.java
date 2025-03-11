package com.sistema.intranet.config.UserDetails;

import com.sistema.intranet.models.TbPerfilResidentado;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Setter
@Getter
public class CustomUserDetails extends User {
    private Integer persona;
    public CustomUserDetails(String username, String password, Set<TbPerfilResidentado> roles, Integer persona) {
        super(
                username,
                password,
                roles.stream().map(rol -> new SimpleGrantedAuthority("ROLE_"+rol.getNombre())).toList());

        this.persona = persona;
    }
}
