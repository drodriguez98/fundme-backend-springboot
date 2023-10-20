package com.campusdual.fundme.model.dao;

// Este archivo define una interfaz que extiende JpaRepository, que proporciona métodos para realizar operaciones de base de datos en la entidad Project.

import com.campusdual.fundme.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    List<Project> findTop3ByOrderByTotalAmountDesc();
    List<Project> findTop3ByOrderByDateAddedDesc();

}