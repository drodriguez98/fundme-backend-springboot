package com.campusdual.fundme.restcontroller;

import com.campusdual.fundme.api.IProjectService;
import com.campusdual.fundme.api.IUserService;
import com.campusdual.fundme.model.Donation;
import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.dto.ProjectDTO;
import com.campusdual.fundme.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectRestController {

    @Autowired
    private IProjectService projectService;

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/get")
    public ProjectDTO queryProject (@RequestBody ProjectDTO project) { return this.projectService.getProject(project); }

    @PostMapping(value="/getByUser")
    public List<Project> queryProjectsByUser (@RequestBody UserDTO user) { return this.projectService.getProjectsByUserId(user); }

    @GetMapping(value = "/all")
    public List<ProjectDTO> queryAllProjects() { return this.projectService.getAllProjects(); }

    @GetMapping(value="/top")
    public List<ProjectDTO> queryTopProjects() { return this.projectService.getTopProjects(); }

    @PostMapping(value = "/add")
    public int insertProject (@RequestBody ProjectDTO project) { return this.projectService.insertProject(project); }

    @PutMapping(value = "/update")
    public int updateProject (@RequestBody ProjectDTO project) { return this.projectService.updateProject(project); }

    @PostMapping(value = "/delete")
    public int deleteProject (@RequestBody ProjectDTO project) { return this.projectService.deleteProject(project); }

}