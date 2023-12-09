package com.campusdual.fundme.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Lazy
    private AjaxRoleFilter ajaxRoleFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .addFilterBefore(ajaxRoleFilter, UsernamePasswordAuthenticationFilter.class) // Agrega el filtro antes de la autorización

                .csrf().disable()

                .authorizeRequests()
                .antMatchers("/login", "/register").permitAll()
                .antMatchers("/**").authenticated()
                //.antMatchers("/**").hasRole("ADMIN")
                //.antMatchers("/search").authenticated() // Requiere autenticación, pero no necesita el rol AJAX_ROLE

                .anyRequest().authenticated()
                .and()

                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/authentication")
                .defaultSuccessUrl("/dashboard", true)
                .and()

                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
                .permitAll()
                .and()

                .exceptionHandling()
                .accessDeniedPage("/error");
    }

    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Bean
    public AjaxRoleFilter ajaxRoleFilter() { return new AjaxRoleFilter(); }

}