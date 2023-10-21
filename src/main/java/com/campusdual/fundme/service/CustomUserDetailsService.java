package com.campusdual.fundme.service;

// Esta clase implementa la interfaz UserDetailsService de Spring Security.
// Su función es cargar los detalles del usuario desde la base de datos, como el nombre de usuario y la contraseña encriptada, y devolverlos como un objeto UserDetails.

import com.campusdual.fundme.model.User;
import com.campusdual.fundme.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);

        if (user == null) { throw new UsernameNotFoundException("User not found"); }

        List<GrantedAuthority> authorities = new ArrayList<>();

        if (user.isAdmin()) {

            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        } else {

            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        }

        return new org.springframework.security.core.userdetails.User (user.getUsername(), user.getPassword(), authorities);

    }

}