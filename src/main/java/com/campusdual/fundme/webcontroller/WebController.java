package com.campusdual.fundme.webcontroller;

import com.campusdual.fundme.model.Donation;
import com.campusdual.fundme.model.Project;
import com.campusdual.fundme.model.User;

import com.campusdual.fundme.model.dto.AreaDTO;
import com.campusdual.fundme.model.dto.CountryDTO;
import com.campusdual.fundme.model.dto.ProjectDTO;
import com.campusdual.fundme.model.dto.UserDTO;

import com.campusdual.fundme.model.dto.dtopmapper.DonationMapper;
import com.campusdual.fundme.model.dto.dtopmapper.ProjectMapper;
import com.campusdual.fundme.model.dto.dtopmapper.UserMapper;

import com.campusdual.fundme.api.IDonationService;
import com.campusdual.fundme.api.IProjectService;
import com.campusdual.fundme.api.IUserService;

import com.campusdual.fundme.service.AreaService;
import com.campusdual.fundme.service.CountryService;
import com.campusdual.fundme.service.CustomUserDetailsService;
import com.campusdual.fundme.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/fundme/controller/web")
public class WebController {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private AreaService areaService;
    @Autowired
    private IUserService userService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private IProjectService projectService;

    @Autowired
    private IDonationService donationService;

    @GetMapping("/login")
    public String showLoginForm() { return "login";  }

    @PostMapping("/authentication")
    public String authenticate(@RequestParam String username, @RequestParam String password) {

        boolean isAuthenticated = loginService.authenticate(username, password);

        if (isAuthenticated) {

            return "redirect:/fundme/controller/web/dashboard";

        } else {

            return "redirect:/fundme/controller/web/login"; // return "redirect:/api/public/showLoginForm?error=true";

        }

    }

    @GetMapping("/register")
    public String showRegisterForm (Model model) {

        List<CountryDTO> countries = countryService.getAllCountries();
        model.addAttribute("countries", countries);
        model.addAttribute("user", new UserDTO());

        return "register";

    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("user") UserDTO userDTO) {

        userService.insertUser(userDTO);

        return "redirect:/fundme/controller/web/login";

    }

    @GetMapping(value = "/dashboard")
    public String dashboard(Model model) {

        List<Project> topProjectsList = projectService.getTopProjects();
        model.addAttribute("topProjectsList", topProjectsList);

        List<Project> lastProjectsList = projectService.getLastProjects();
        model.addAttribute("lastProjectsList", lastProjectsList);

        return "dashboard";

    }

    @GetMapping(value = "/allProjects")
    public String allProjects(Model model) {

        List<ProjectDTO> projectList = projectService.getAllProjects();
        model.addAttribute("projectList", projectList);

        return "all-projects";
    }

    @GetMapping(value = "/viewProject/{project_id}")
    public String viewProject(@PathVariable int project_id, Model model) {

        ProjectDTO projectDetails = projectService.getProjectById(project_id);
        model.addAttribute("projectDetails", projectDetails);

        return "view-project";

    }

    @GetMapping(value = "/donations")
    public String donations(Model model) {

        List<Donation> topDonationsList = donationService.getTopDonations();
        model.addAttribute("topDonationsList", topDonationsList);

        List<Donation> lastDonationsList = donationService.getLastDonations();
        model.addAttribute("lastDonationsList", lastDonationsList);

        return "donations";

    }

    @GetMapping(value = "/userProfile")
    public String userProfile(Model model) {

        UserDTO authenticatedUser = userService.getUser(new UserDTO());
        model.addAttribute("authenticatedUser", authenticatedUser);

        return "user-profile";

    }

    @GetMapping("/donate/{project_id}")
    public String donateToProject (@PathVariable("project_id") int project_id, Model model) {

        ProjectDTO project = projectService.getProjectById(project_id);
        model.addAttribute("project", project);

        return "donate-project";

    }

    @PostMapping("/donate/{project_id}")
    public String donateToProject(@PathVariable("project_id") int project_id, @RequestParam("amount") int amount) {

        ProjectDTO projectDTO = projectService.getProjectById(project_id);
        UserDTO authenticatedUser = userService.getUser(new UserDTO());

        Project project = ProjectMapper.INSTANCE.toEntity(projectDTO);
        User user = UserMapper.INSTANCE.toEntity(authenticatedUser);

        Donation donation = new Donation();

        donation.setUser_id(user);
        donation.setProject_id(project);
        donation.setAmount(amount);
        donation.setDateAdded(new Date());

        donationService.insertDonation(DonationMapper.INSTANCE.toDTO(donation));

        project.setTotalAmount(project.getTotalAmount() + amount);
        projectService.updateProject(ProjectMapper.INSTANCE.toDTO(project));

        return "redirect:/fundme/controller/web/donations";

    }

    @GetMapping(value = "/createProject")
    public String createProject (Model model) {

        List<AreaDTO> areas = areaService.getAllAreas();
        model.addAttribute("areas", areas);
        model.addAttribute("project", new ProjectDTO());

        return "create-project";

    }

    @PostMapping("/createProject")
    public String processRegistration(@ModelAttribute("project") ProjectDTO projectDTO) {

        Project project = ProjectMapper.INSTANCE.toEntity(projectDTO);

        UserDTO authenticatedUser = userService.getUser(new UserDTO());
        User user = UserMapper.INSTANCE.toEntity(authenticatedUser);

        project.setUser_id(user);
        project.setDateAdded(new Date());
        int totalAmount = 0;
        project.setTotalAmount(totalAmount);

        projectService.insertProject(ProjectMapper.INSTANCE.toDTO(project));

        return "redirect:/fundme/controller/web/allProjects";

    }

    @GetMapping("/accessDenied")
    public String customErrorPage() { return "error"; }

    @GetMapping(value = "/logout")
    public String logout (HttpServletRequest request) {

        request.getSession().invalidate();

        return "redirect:/fundme/controller/web/login";

    }

    @GetMapping("/admin")
    @ResponseBody
    public String dashboardAdmin() {
        return "Welcome to the administration area";
    }

    @GetMapping(value = "/myProjects")
    @ResponseBody
    public String myProjects() { return "Wellcome to my projects"; }

    @GetMapping(value = "/myDonations")
    @ResponseBody
    public String myDonations() { return "Wellcome to my donations"; }

    @GetMapping(value = "/settings")
    @ResponseBody
    public String settings() { return "Wellcome to settings"; }

    @GetMapping(value = "/editProfile")
    @ResponseBody
    public String editProfile() { return "Edit profile"; }





}