package com.campusdual.fundme.api;

import com.campusdual.fundme.model.dto.ProjectDTO;
import java.util.List;

public interface IProjectService {

    ProjectDTO queryProject (ProjectDTO projectDTO);
    List<ProjectDTO> queryAllProjects();
    int insertProject (ProjectDTO projectDTO);
    int updateProject (ProjectDTO projectDTO);
    int deleteProject (ProjectDTO projectDTO);

}