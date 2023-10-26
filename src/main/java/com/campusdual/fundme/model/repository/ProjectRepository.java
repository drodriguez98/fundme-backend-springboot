package com.campusdual.fundme.model.repository;

import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    List<Project> findTop5ByOrderByTotalAmountDesc();
    List<Project> findTop5ByOrderByDateAddedDesc();
    List<Project> findByUserId(User user);

}