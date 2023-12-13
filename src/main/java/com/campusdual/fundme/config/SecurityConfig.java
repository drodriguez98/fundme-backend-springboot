package com.campusdual.fundme.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*
    @Autowired
    @Lazy
    private AjaxRoleFilter ajaxRoleFilter;
    */

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                //.addFilterBefore(ajaxRoleFilter, UsernamePasswordAuthenticationFilter.class) // Agrega el filtro antes de la autorización

                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/users/authentication", "/users/register", "/countries/all").permitAll()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                //.antMatchers("/login", "/register").permitAll()
                //.antMatchers("/**").authenticated()
                //.antMatchers("/**").hasRole("ADMIN")
                //.antMatchers("/search").authenticated() // Requiere autenticación, pero no necesita el rol AJAX_ROLE
                .anyRequest().authenticated()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/error");

        // Añade el filtro JWT antes del filtro UsernamePasswordAuthenticationFilter

        http.addFilterBefore(new JwtTokenFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    /*
    @Bean
    public AjaxRoleFilter ajaxRoleFilter() { return new AjaxRoleFilter(); }
     */

}