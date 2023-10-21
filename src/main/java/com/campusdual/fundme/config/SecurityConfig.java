package com.campusdual.fundme.config;

import com.campusdual.fundme.service.CustomUserDetailsService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            .csrf().disable()

            .authorizeRequests()

                .antMatchers("/fundme/controller/web/login", "/fundme/controller/web/register").permitAll()
                .antMatchers("/fundme/controller/rest/**").hasRole("ADMIN")
                .antMatchers("/fundme/controller/web/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()

                .and()

            .formLogin()

                .loginPage("/fundme/controller/web/login")
                .loginProcessingUrl("/fundme/controller/web/authentication")
                .defaultSuccessUrl("/fundme/controller/web/dashboard", true)

                .and()

            .logout()

                .logoutUrl("/fundme/controller/web/logout")
                .logoutSuccessUrl("/fundme/controller/web/login")
                .permitAll()

                .and()

            .exceptionHandling()

                .accessDeniedPage("/error");

    }

    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    public void configureGlobal(AuthenticationManagerBuilder auth, CustomUserDetailsService customUserDetailsService) throws Exception {

        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());

    }

}