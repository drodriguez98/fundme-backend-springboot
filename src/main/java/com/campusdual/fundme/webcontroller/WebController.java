package com.campusdual.fundme.webcontroller;

import com.campusdual.fundme.api.ICountryService;
import com.campusdual.fundme.api.IDonationService;
import com.campusdual.fundme.api.IProjectService;
import com.campusdual.fundme.api.IUserService;
import com.campusdual.fundme.model.Country;
import com.campusdual.fundme.model.dto.CountryDTO;
import com.campusdual.fundme.model.dto.DonationDTO;
import com.campusdual.fundme.model.dto.ProjectDTO;
import com.campusdual.fundme.model.dto.UserDTO;
import com.campusdual.fundme.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/fundme/controller/web")
public class WebController {

    // Inyección de instancias

    @Autowired
    private IUserService userService;

    @Autowired
    private LoginService loginService;


    @Autowired
    private IProjectService projectService;

    @Autowired
    private IDonationService donationService;

    @GetMapping("/login")
    public String showLoginForm() { return "login";  }



    // Obtiene la lista de proyectos desde el servicio y agrega projectList al modelo

    @GetMapping(value = "/dashboard")
    public String dashboard(Model model) {

        List<ProjectDTO> projectList = projectService.getAllProjects();
        model.addAttribute("projectList", projectList);

        return "dashboard";
    }

    @GetMapping(value = "/createProject")
    public String creatProject() { return "create-project"; }

    // Obtiene la lista de donaciones desde el servicio y agrega donationList al modelo

    @GetMapping(value = "/donations")
    public String donations(Model model) {

        List<DonationDTO> donationList = donationService.getAllDonations();
        model.addAttribute("donationList", donationList);

        return "donations";

    }

    @GetMapping(value = "/myDonations")
    public String myDonations() { return "my-donations"; }

    @GetMapping(value = "/userProfile")
    public String userProfile(Model model) {

        UserDTO authenticatedUser = userService.getUser(new UserDTO());
        model.addAttribute("authenticatedUser", authenticatedUser);

        return "user-profile";

    }


    @GetMapping(value = "/viewProject/{project_id}")
    public String viewProject(@PathVariable int project_id, Model model) {

        ProjectDTO projectDetails = projectService.getProjectById(project_id);
        model.addAttribute("projectDetails", projectDetails);

        return "view-project";

    }

    @GetMapping(value = "/myProjects")
    public String myProjects() { return "my-projects"; }

    @GetMapping(value = "/allProjects")
    public String allProjects(Model model) {

        List<ProjectDTO> projectList = projectService.getAllProjects(); // Obtén la lista de proyectos desde tu servicio
        model.addAttribute("projectList", projectList); // Agrega projectList al modelo

        return "all-projects";
    }

    @GetMapping(value = "/settings")
    public String settings() { return "settings"; }

    @GetMapping(value = "/logout")
    public String logout() { return "logout"; }

}