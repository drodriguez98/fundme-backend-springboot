package com.campusdual.fundme.api;

import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.dto.ProjectDTO;
import java.util.List;

public interface IProjectService {

    ProjectDTO getProjectById(int project_d);
    ProjectDTO getProject(ProjectDTO projectDTO);
    List<ProjectDTO> getAllProjects();

    int insertProject (ProjectDTO projectDTO);
    int updateProject (ProjectDTO projectDTO);
    int deleteProject (ProjectDTO projectDTO);

    List<Project> getTopProjects();
    List<Project> getLastProjects();

}