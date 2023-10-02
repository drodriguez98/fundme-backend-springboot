package com.campusdual.fundme.model.dao;

import com.campusdual.fundme.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDAO extends JpaRepository<Comment, Integer> {}