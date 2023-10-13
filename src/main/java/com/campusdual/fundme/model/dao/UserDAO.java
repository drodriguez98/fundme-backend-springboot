package com.campusdual.fundme.model.dao;

import com.campusdual.fundme.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}