package com.campusdual.fundme.service;

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