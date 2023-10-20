package com.campusdual.fundme.service;

import com.campusdual.fundme.api.ILoginService;
import com.campusdual.fundme.model.User;
import com.campusdual.fundme.model.dao.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService implements ILoginService {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    // Realiza la lógica de autenticación con Hibernate
    // Verifica la contraseña utilizando el PasswordEncoder configurado en SecurityConfig

    @Override
    @Transactional
    public boolean authenticate(String username, String password) {

        User user = userRepository.findByUsername(username);

        if (user != null) { return passwordEncoder.matches(password, user.getPassword()); }

        return false;

    }

}