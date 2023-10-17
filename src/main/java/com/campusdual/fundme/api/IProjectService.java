package com.campusdual.fundme.api;

// Esta interfaz define métodos que deben ser implementados por un servicio que maneja operaciones relacionadas con proyectos.
// Incluye operaciones para consultar, insertar, actualizar y eliminar proyectos.

import com.campusdual.fundme.model.dto.ProjectDTO;
import java.util.List;

public interface IProjectService {

    ProjectDTO getProject(ProjectDTO projectDTO);

    ProjectDTO getProjectById(int project_d);

    List<ProjectDTO> getAllProjects();
    int insertProject (ProjectDTO projectDTO);
    int updateProject (ProjectDTO projectDTO);
    int deleteProject (ProjectDTO projectDTO);

}