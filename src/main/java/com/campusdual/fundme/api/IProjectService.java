package com.campusdual.fundme.api;

import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.dto.ProjectDTO;

import java.util.List;

public interface IProjectService {

    ProjectDTO getProject(ProjectDTO projectDTO);
    ProjectDTO getProjectById(int projectId);
    List<ProjectDTO> getAllProjects();

    int insertProject (ProjectDTO projectDTO);
    int updateProject (ProjectDTO projectDTO);
    int deleteProject (ProjectDTO projectDTO);

    List<Project> getTopProjects();
    List<Project> getProjectsByAuthenticatedUserOrderByDateAddedDesc();

    int getProjectCountByUser(int userId);
}