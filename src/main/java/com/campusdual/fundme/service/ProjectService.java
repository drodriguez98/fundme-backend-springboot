package com.campusdual.fundme.service;

import com.campusdual.fundme.api.IProjectService;
import com.campusdual.fundme.api.IUserService;
import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.User;
import com.campusdual.fundme.model.dto.UserDTO;
import com.campusdual.fundme.model.dto.dtopmapper.UserMapper;
import com.campusdual.fundme.model.repository.ProjectRepository;
import com.campusdual.fundme.model.dto.ProjectDTO;
import com.campusdual.fundme.model.repository.UserRepository;

import com.campusdual.fundme.model.dto.dtopmapper.ProjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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
    public List<ProjectDTO> getTopProjects() { return ProjectMapper.INSTANCE.toDTOList(projectRepository.findTop5ByOrderByTotalAmountDesc()); }

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

    @Override
    public List<Project> getProjectsByUserId(UserDTO userDTO) {

        User user = UserMapper.INSTANCE.toEntity(userDTO);

        return projectRepository.findByUserIdOrderByDateAddedDesc(user);

    }

    @Override
    public int getProjectCountByUser(int userId) {

        User user = userRepository.getReferenceById(userId);

        return projectRepository.getProjectCountByUser(user);

    }

}