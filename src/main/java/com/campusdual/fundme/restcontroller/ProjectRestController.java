package com.campusdual.fundme.restcontroller;

// Este controlador define rutas y métodos que gestionan las solicitudes relacionadas con los proyectos.
// Utiliza el servicio IProjectService para llevar a cabo operaciones como consultar, insertar, actualizar y eliminar proyectos.

import com.campusdual.fundme.api.IProjectService;
import com.campusdual.fundme.model.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/fundme/controller/rest/projects")
public class ProjectRestController {

    @Autowired
    private IProjectService projectService;

    @PostMapping(value = "/get")
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