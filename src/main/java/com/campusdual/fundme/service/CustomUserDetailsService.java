package com.campusdual.fundme.service;

import com.campusdual.fundme.model.User;
import com.campusdual.fundme.model.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import static java.util.Collections.emptyList;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    // Devuelve un objeto UserDetails con los detalles del usuario (nombre de usuario y contraseña encriptada)

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDAO.findByUsername(username);

        if (user == null) { throw new UsernameNotFoundException("Usuario no encontrado"); }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), emptyList());

    }

}