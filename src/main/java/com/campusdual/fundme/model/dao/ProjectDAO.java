package com.campusdual.fundme.model.dao;

import com.campusdual.fundme.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDAO extends JpaRepository<Project, Integer> {}