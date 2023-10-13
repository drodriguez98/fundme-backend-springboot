package com.campusdual.fundme.model.dao;

// Este archivo define una interfaz que extiende JpaRepository, que proporciona métodos para realizar operaciones de base de datos en la entidad Project.

import com.campusdual.fundme.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDAO extends JpaRepository<Project, Integer> {}