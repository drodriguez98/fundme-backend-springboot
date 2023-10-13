package com.campusdual.fundme.model.dao;

// Este archivo define una interfaz que extiende JpaRepository, que proporciona métodos para realizar operaciones de base de datos en la entidad Comment.

import com.campusdual.fundme.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDAO extends JpaRepository<Comment, Integer> {}