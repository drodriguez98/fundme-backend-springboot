package com.campusdual.fundme.webcontroller;

import com.campusdual.fundme.api.IDonationService;
import com.campusdual.fundme.api.IProjectService;
import com.campusdual.fundme.api.IUserService;
import com.campusdual.fundme.model.dto.DonationDTO;
import com.campusdual.fundme.model.dto.ProjectDTO;
import com.campusdual.fundme.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/fundme/controller/web")
public class WebController {

    @Autowired
    private IUserService userService;

    @Autowired
    private LoginService loginService; // Inyecta una instancia de LoginService

    @Autowired
    private IProjectService projectService;

    @Autowired
    private IDonationService donationService;
    // Redirige a la página de inicio de sesión (login.html)

    @GetMapping("/login")
    public String loginPage() { return "login"; }

    @GetMapping(value = "/dashboard")
    public String dashboard(Model model) {

        List<ProjectDTO> projectList = projectService.queryAllProjects(); // Obtén la lista de proyectos desde tu servicio
        model.addAttribute("projectList", projectList); // Agrega projectList al modelo

        return "dashboard";
    }

    @GetMapping(value = "/createProject")
    public String creatProject() { return "create-project"; }

    @GetMapping(value = "/donations")
    public String donations(Model model) {

        List<DonationDTO> donationList = donationService.queryAllDonations(); // Obtén la lista de proyectos desde tu servicio
        model.addAttribute("donationList", donationList); // Agrega projectList al modelo


        return "donations";

    }

    @GetMapping(value = "/myDonations")
    public String myDonations() { return "my-donations"; }

    @GetMapping(value = "/userProfile")
    public String userProfile() { return "user-profile"; }

    @GetMapping(value = "/viewProject/{project_id}")
    public String viewProject(@PathVariable int project_id, Model model) {

        ProjectDTO projectDetails = projectService.queryProjectById(project_id);
        model.addAttribute("projectDetails", projectDetails);

        return "view-project";

    }

    @GetMapping(value = "/myProjects")
    public String myProjects() { return "my-projects"; }

    @GetMapping(value = "/allProjects")
    public String allProjects(Model model) {

        List<ProjectDTO> projectList = projectService.queryAllProjects(); // Obtén la lista de proyectos desde tu servicio
        model.addAttribute("projectList", projectList); // Agrega projectList al modelo

        return "all-projects";
    }

    @GetMapping(value = "/settings")
    public String settings() { return "settings"; }

    @GetMapping(value = "/logout")
    public String logout() { return "logout"; }

}