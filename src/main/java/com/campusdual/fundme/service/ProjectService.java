package com.campusdual.fundme.service;

import com.campusdual.fundme.api.IProjectService;
import com.campusdual.fundme.model.dao.ProjectDAO;
import com.campusdual.fundme.model.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProjectService")
@Lazy
public class ProjectService implements IProjectService {

    @Autowired
    private ProjectDAO projectDAO;

    @Override
    public ProjectDTO queryProject (ProjectDTO projectDTO) { return null; }
    @Override
    public List<ProjectDTO> queryAllProjects() { return null; }
    @Override
    public int insertProject (ProjectDTO projectDTO) { return 0; }
    @Override
    public int updateProject (ProjectDTO projectDTO) { return 0; }
    @Override
    public int deleteProject (ProjectDTO projectDTO) { return 0; }

}
