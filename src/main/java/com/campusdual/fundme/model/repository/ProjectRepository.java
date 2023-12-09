package com.campusdual.fundme.model.repository;

import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.User;
import com.campusdual.fundme.model.dto.ProjectDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    List<Project> findTop5ByOrderByTotalAmountDesc();
    List<ProjectDTO> findTop5ByOrderByDateAddedDesc();
    List<Project> findByUserIdOrderByDateAddedDesc(User user);

    @Query("SELECT COUNT(p) FROM Project p WHERE p.userId = :userId")
    Integer getProjectCountByUser(@Param("userId") User user);
    
    List<Project> findProjectsByTitleContaining(String query);

}