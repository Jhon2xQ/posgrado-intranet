package com.sistema.intranet.config;

import com.sistema.intranet.config.UserDetails.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfig {

    private final CustomUserDetailsService customUserDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(request -> {
                            request.requestMatchers("/images/*", "/css/*", "/js/*").permitAll();     //permitir los recursos a todos.
                            request.requestMatchers("/notas","/pagos").hasRole("ESTUDIANTE");          //enlaces solo para Estudiante.
                            request.anyRequest().authenticated();
                })
                .formLogin(httpForm -> {
                    httpForm.loginPage("/login").permitAll();                                              //Indicar la interfaz del login.
                    httpForm.failureUrl("/login?error=true");                           //Redirigir en caso de error en login.
                    httpForm.defaultSuccessUrl("/dashboard", true);               //redirigir al dashboard para login exitoso.
                })
                .logout(logout -> logout
                        .logoutSuccessUrl("/login")                                                        //redirigir al login cuando se cierra sesion.
                        .invalidateHttpSession(true)                                                       //Invalidar su sesion.
                        .deleteCookies("JSESSIONID")                                    //Eliminar el ID de sesion.
                );
        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return customUserDetailsService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {return new BCryptPasswordEncoder();}
}
