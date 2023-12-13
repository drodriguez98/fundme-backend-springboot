package com.campusdual.fundme.api;

import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.dto.ProjectDTO;
import com.campusdual.fundme.model.dto.UserDTO;

import java.util.List;

public interface IProjectService {

    ProjectDTO getProject(ProjectDTO projectDTO);
    ProjectDTO getProjectById(int projectId);
    List<ProjectDTO> getAllProjects();
    List<ProjectDTO> getTopProjects();

    int insertProject (ProjectDTO projectDTO);
    int updateProject (ProjectDTO projectDTO);
    int deleteProject (ProjectDTO projectDTO);


    // List<Project> getProjectsByAuthenticatedUserOrderByDateAddedDesc();

    List<Project> getProjectsByUserId(UserDTO userDTO);

    int getProjectCountByUser(int userId);

}