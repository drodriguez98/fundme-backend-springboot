package com.campusdual.fundme.api;

// Esta interfaz define métodos que deben ser implementados por un servicio que maneja operaciones relacionadas con proyecyod.

// Incluye operaciones para consultar, insertar, actualizar y eliminar proyectos.

import com.campusdual.fundme.model.dto.ProjectDTO;
import java.util.List;

public interface IProjectService {

    ProjectDTO queryProject (ProjectDTO projectDTO);
    List<ProjectDTO> queryAllProjects();
    int insertProject (ProjectDTO projectDTO);
    int updateProject (ProjectDTO projectDTO);
    int deleteProject (ProjectDTO projectDTO);

}