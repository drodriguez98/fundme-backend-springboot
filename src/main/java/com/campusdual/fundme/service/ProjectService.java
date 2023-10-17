package com.campusdual.fundme.service;

// Esta clase implementa la interfaz IProjectService y proporciona la lógica de negocio para manejar operaciones relacionadas con proyectos.
// Se encarga de transformar objetos ProjectDTO en objetos Project y viceversa.

import com.campusdual.fundme.api.IProjectService;
import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.dao.ProjectRepository;
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
    private ProjectRepository projectDAO;

    @Override
    public ProjectDTO getProject(ProjectDTO projectDTO) {

        Project project = ProjectMapper.INSTANCE.toEntity(projectDTO);
        return ProjectMapper.INSTANCE.toDTO(this.projectDAO.getReferenceById(project.getProject_id()));

    }

    @Override
    public ProjectDTO getProjectById(int project_d) {

        Project project = projectDAO.getReferenceById(project_d);
        return ProjectMapper.INSTANCE.toDTO(project);

    }

    @Override
    public List<ProjectDTO> getAllProjects() { return ProjectMapper.INSTANCE.toDTOList(projectDAO.findAll()); }

    @Override
    public int insertProject (ProjectDTO projectDTO) {

        Project project = ProjectMapper.INSTANCE.toEntity(projectDTO);
        this.projectDAO.saveAndFlush(project);
        return project.getProject_id();

    }

    @Override
    public int updateProject (ProjectDTO projectDTO) { return this.insertProject(projectDTO); }

    @Override
    public int deleteProject (ProjectDTO projectDTO) {

        int id = projectDTO.getProject_id();
        Project project = ProjectMapper.INSTANCE.toEntity(projectDTO);
        this.projectDAO.delete(project);
        return id;

    }

}