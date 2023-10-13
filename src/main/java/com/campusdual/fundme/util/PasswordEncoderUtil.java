package com.campusdual.fundme.util;

// Esta clase se encarga de proporcionar funcionalidad para codificar contraseñas.

// Utiliza la biblioteca Spring Security para codificar contraseñas utilizando el algoritmo BCrypt.

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderUtil {

    private final PasswordEncoder passwordEncoder;

    public PasswordEncoderUtil() { this.passwordEncoder = new BCryptPasswordEncoder(); }

    public String encodePassword(String plainPassword) { return passwordEncoder.encode(plainPassword); }

}