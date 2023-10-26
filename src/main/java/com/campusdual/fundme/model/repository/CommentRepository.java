package com.campusdual.fundme.model.repository;

import com.campusdual.fundme.model.Comment;
import com.campusdual.fundme.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List<Comment> findByProjectIdOrderByDateAddedDesc(Project project);

}