package com.sistema.intranet.services.myServices.UserDetails;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;
import java.util.List;

@Setter
@Getter
public class CustomUserDetails extends User {
    private Integer persona;
    public CustomUserDetails(String username, String password, Integer persona) {
        super(username, password, List.of());
        this.persona = persona;
    }
}
