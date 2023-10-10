package com.campusdual.fundme.security;

/*

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.campusdual.fundme.service.UserService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/auth/**").permitAll() // Rutas de autenticación públicas
                .anyRequest().authenticated() // Otras rutas requieren autenticación
                .and()
                .formLogin()
                .loginProcessingUrl("/api/auth/login") // URL de procesamiento de inicio de sesión
                .defaultSuccessURL("/api/auth/success") // URL de éxito después del inicio de sesión
                .failureUrl("/api/auth/failure") // URL en caso de fallo de inicio de sesión
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/api/auth/logout") // URL de cierre de sesión
                .logoutSuccessUrl("/login") // URL de éxito después del cierre de sesión
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

*/