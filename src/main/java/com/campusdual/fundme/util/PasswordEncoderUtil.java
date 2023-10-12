package com.campusdual.fundme.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderUtil {

    private final PasswordEncoder passwordEncoder;

    public PasswordEncoderUtil() { this.passwordEncoder = new BCryptPasswordEncoder(); }

    public String encodePassword(String plainPassword) { return passwordEncoder.encode(plainPassword); }

}