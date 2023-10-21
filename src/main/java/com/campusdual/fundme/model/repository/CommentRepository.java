package com.campusdual.fundme.model.repository;

import com.campusdual.fundme.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {}