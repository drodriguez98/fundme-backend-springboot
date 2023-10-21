package com.campusdual.fundme.service;

import com.campusdual.fundme.api.IProjectService;
import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.repository.ProjectRepository;
import com.campusdual.fundme.model.dto.ProjectDTO;
import com.campusdual.fundme.model.dto.dtopmapper.ProjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("ProjectService")
@Lazy
public class ProjectService implements IProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public ProjectDTO getProject(ProjectDTO projectDTO) {

        Project project = ProjectMapper.INSTANCE.toEntity(projectDTO);
        return ProjectMapper.INSTANCE.toDTO(this.projectRepository.getReferenceById(project.getProject_id()));

    }

    @Override
    public ProjectDTO getProjectById(int project_d) {

        Project project = projectRepository.getReferenceById(project_d);
        return ProjectMapper.INSTANCE.toDTO(project);

    }

    @Override
    public List<ProjectDTO> getAllProjects() { return ProjectMapper.INSTANCE.toDTOList(projectRepository.findAll()); }

    @Override
    public int insertProject (ProjectDTO projectDTO) {

        Project project = ProjectMapper.INSTANCE.toEntity(projectDTO);
        this.projectRepository.saveAndFlush(project);
        return project.getProject_id();

    }

    @Override
    public int updateProject (ProjectDTO projectDTO) { return this.insertProject(projectDTO); }

    @Override
    public int deleteProject (ProjectDTO projectDTO) {

        int id = projectDTO.getProject_id();
        Project project = ProjectMapper.INSTANCE.toEntity(projectDTO);
        this.projectRepository.delete(project);
        return id;

    }

    public List<Project> getTopProjects() { return projectRepository.findTop3ByOrderByTotalAmountDesc(); }

    public List<Project> getLastProjects() { return projectRepository.findTop3ByOrderByDateAddedDesc(); }

}