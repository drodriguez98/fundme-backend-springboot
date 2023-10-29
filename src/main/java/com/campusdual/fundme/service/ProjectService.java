package com.campusdual.fundme.service;

import com.campusdual.fundme.api.IProjectService;
import com.campusdual.fundme.api.IUserService;
import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.User;
import com.campusdual.fundme.model.repository.ProjectRepository;
import com.campusdual.fundme.model.dto.ProjectDTO;
import com.campusdual.fundme.model.repository.UserRepository;

import com.campusdual.fundme.model.dto.dtopmapper.ProjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProjectService")
@Lazy
public class ProjectService implements IProjectService {

    private IUserService userService;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ProjectDTO getProject(ProjectDTO projectDTO) {

        Project project = ProjectMapper.INSTANCE.toEntity(projectDTO);

        return ProjectMapper.INSTANCE.toDTO(this.projectRepository.getReferenceById(project.getProjectId()));

    }

    @Override
    public ProjectDTO getProjectById(int projectId) {

        Project project = projectRepository.getReferenceById(projectId);

        return ProjectMapper.INSTANCE.toDTO(project);

    }

    @Override
    public List<ProjectDTO> getAllProjects() { return ProjectMapper.INSTANCE.toDTOList(projectRepository.findAll()); }

    @Override
    public int insertProject (ProjectDTO projectDTO) {

        Project project = ProjectMapper.INSTANCE.toEntity(projectDTO);
        this.projectRepository.saveAndFlush(project);

        return project.getProjectId();

    }

    @Override
    public int updateProject (ProjectDTO projectDTO) { return this.insertProject(projectDTO); }

    @Override
    public int deleteProject (ProjectDTO projectDTO) {

        int id = projectDTO.getProjectId();
        Project project = ProjectMapper.INSTANCE.toEntity(projectDTO);
        this.projectRepository.delete(project);

        return id;

    }

    public List<Project> getTopProjects() { return projectRepository.findTop5ByOrderByTotalAmountDesc(); }

    @Override
    public List<Project> getProjectsByAuthenticatedUserOrderByDateAddedDesc() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) { throw new RuntimeException("Ningún usuario autenticado."); }

        String username = authentication.getName();

        User authenticatedUser = userRepository.findByUsername(username);

        if (authenticatedUser == null) { throw new RuntimeException("Usuario autenticado no encontrado."); }

        return projectRepository.findByUserIdOrderByDateAddedDesc(authenticatedUser);

    }

    @Override
    public int getProjectCountByUser(int userId) {

        User user = userRepository.getReferenceById(userId);

        return projectRepository.getProjectCountByUser(user); }

    public List<Project> getLastProjects() { return projectRepository.findTop5ByOrderByDateAddedDesc(); }

}