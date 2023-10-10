package com.campusdual.fundme.controller;

import com.campusdual.fundme.api.IProjectService;
import com.campusdual.fundme.model.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private IProjectService projectService;

    @PostMapping(value = "/project/...")
    public ProjectDTO queryProject (@RequestBody ProjectDTO project) { return this.projectService.queryProject(project); }

    @GetMapping(value = "/all")
    public List<ProjectDTO> queryAllProjects() { return this.projectService.queryAllProjects(); }

    @PostMapping(value = "/add")
    public int insertProject (@RequestBody ProjectDTO project) { return this.projectService.insertProject(project); }

    @PutMapping(value = "/update")
    public int updateProject (@RequestBody ProjectDTO project) { return this.projectService.updateProject(project); }

    @PostMapping(value = "/delete")
    public int deleteProject (@RequestBody ProjectDTO project) { return this.projectService.deleteProject(project); }

}