package com.campusdual.fundme.webcontroller;

import com.campusdual.fundme.api.INotificationService;

import com.campusdual.fundme.model.*;
import com.campusdual.fundme.model.dto.*;

import com.campusdual.fundme.model.dto.dtopmapper.CommentMapper;
import com.campusdual.fundme.model.dto.dtopmapper.DonationMapper;
import com.campusdual.fundme.model.dto.dtopmapper.ProjectMapper;
import com.campusdual.fundme.model.dto.dtopmapper.UserMapper;

import com.campusdual.fundme.api.IDonationService;
import com.campusdual.fundme.api.IProjectService;
import com.campusdual.fundme.api.IUserService;

import com.campusdual.fundme.model.repository.ProjectRepository;
import com.campusdual.fundme.model.repository.UserRepository;
import com.campusdual.fundme.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.ArrayList;
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
    private CommentService commentService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private IProjectService projectService;

    @Autowired
    private IDonationService donationService;

    @Autowired
    private INotificationService notificationService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/login")
    public String showLoginForm() { return "login";  }

    @PostMapping("/authentication")
    public String authenticate(@RequestParam String username, @RequestParam String password) {

        boolean isAuthenticated = loginService.authenticate(username, password);

        if (isAuthenticated) { return "dashboard"; } else { return "login"; }

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

    @GetMapping(value = "/createProject")
    public String createProject (Model model) {

        List<AreaDTO> areas = areaService.getAllAreas();

        model.addAttribute("areas", areas);
        model.addAttribute("project", new ProjectDTO());

        return "create-project";

    }

    @PostMapping("/createProject")
    public String createProject (@ModelAttribute("project") ProjectDTO projectDTO) {

        Project project = ProjectMapper.INSTANCE.toEntity(projectDTO);

        UserDTO authenticatedUser = userService.getUser(new UserDTO());
        User user = UserMapper.INSTANCE.toEntity(authenticatedUser);

        project.setUserId(user);
        project.setDateAdded(new Date());
        project.setTotalAmount(0);

        projectService.insertProject(ProjectMapper.INSTANCE.toDTO(project));

        return "redirect:/fundme/controller/web/projects";

    }

    @GetMapping("/donate/{projectId}")
    public String donateToProject (@PathVariable("projectId") int projectId, Model model) {

        ProjectDTO projectDTO = projectService.getProjectById(projectId);

        model.addAttribute("project", projectDTO);

        return "donate-project";

    }

    @PostMapping("/donate/{projectId}")
    public String donateToProject(@PathVariable("projectId") int projectId, @RequestParam("amount") int amount) {

        ProjectDTO projectDTO = projectService.getProjectById(projectId);
        UserDTO authenticatedUser = userService.getUser(new UserDTO());

        Project project = ProjectMapper.INSTANCE.toEntity(projectDTO);
        User donor = UserMapper.INSTANCE.toEntity(authenticatedUser);
        User recipient = project.getUserId();

        Donation donation = new Donation();
        donation.setUserId(donor);
        donation.setProjectId(project);
        donation.setAmount(amount);
        donation.setDateAdded(new Date());

        project.setTotalAmount(project.getTotalAmount() + amount);

        donationService.insertDonation(DonationMapper.INSTANCE.toDTO(donation));
        notificationService.createDonationNotification(recipient, donor, project);
        projectService.updateProject(ProjectMapper.INSTANCE.toDTO(project));

        return "redirect:/fundme/controller/web/donations";

    }

    @GetMapping(value = "/comment/{projectId}")
    public String commentProject (@PathVariable("projectId") int projectId, Model model) {

        ProjectDTO projectDTO = projectService.getProjectById(projectId);

        model.addAttribute("project", projectDTO);
        model.addAttribute("comment", new CommentDTO());

        return "comment-project";

    }

    @PostMapping("/comment/{projectId}")
    public String commentProject(@PathVariable("projectId") int projectId, @ModelAttribute("comment") CommentDTO commentDTO) {

        ProjectDTO projectDTO = projectService.getProjectById(projectId);
        UserDTO authenticatedUser = userService.getUser(new UserDTO());

        Project project = ProjectMapper.INSTANCE.toEntity(projectDTO);
        Comment comment = CommentMapper.INSTANCE.toEntity(commentDTO);

        User commenter = UserMapper.INSTANCE.toEntity(authenticatedUser);

        User recipient = project.getUserId();

        comment.setUserId(commenter);
        comment.setProjectId(project);
        comment.setDateAdded(new Date());

        commentService.insertComment(CommentMapper.INSTANCE.toDTO(comment));

        notificationService.createCommentNotification(recipient, commenter, project);

        return "redirect:/fundme/controller/web/viewProject/{projectId}";

    }

    @GetMapping(value = "/dashboard")
    public String dashboard(Model model) {

        List<Project> topProjectsList = projectService.getTopProjects();
        List<Donation> topDonationsList = donationService.getTopDonations();

        model.addAttribute("topProjectsList", topProjectsList);
        model.addAttribute("topDonationsList", topDonationsList);

        return "dashboard";

    }

    @GetMapping("/search")
    @ResponseBody
    public ResponseEntity<List<SearchResultDTO>> search(@RequestParam String query, HttpServletRequest request) {

        if (isAjaxRequest(request)) {

            List<Project> projectResults = projectRepository.findProjectsByTitleContaining(query);
            List<User> userResults = userRepository.findUsersByUsernameContaining(query);

            List<SearchResultDTO> searchResults = new ArrayList<>();

            for (Project project : projectResults) {

                SearchResultDTO result = new SearchResultDTO();
                result.setType("Project");
                result.setEntity(project);
                searchResults.add(result);

            }

            for (User user : userResults) {

                SearchResultDTO result = new SearchResultDTO();
                result.setType("User");
                result.setEntity(user);
                searchResults.add(result);

            }

            return new ResponseEntity<>(searchResults, HttpStatus.OK);

        } else { return new ResponseEntity<>(HttpStatus.FORBIDDEN); }

    }

    private boolean isAjaxRequest(HttpServletRequest request) {

        String requestedWithHeader = request.getHeader("X-Requested-With");
        String userRoleHeader = request.getHeader("X-User-Role");

        return "XMLHttpRequest".equals(requestedWithHeader) && "AJAX_ROLE".equals(userRoleHeader);

    }

    @GetMapping(value = "/projects")
    public String allProjects(Model model) {

        List<ProjectDTO> projectList = projectService.getAllProjects();

        model.addAttribute("projectList", projectList);

        return "projects";
    }

    @GetMapping(value = "/myProjects")
    public String myProjects(Model model) {

        List<Project> myProjects = projectService.getProjectsByAuthenticatedUserOrderByDateAddedDesc();

        model.addAttribute("myProjects", myProjects);

        return "my-projects";

    }

    @GetMapping(value = "/donations")
    public String donations(Model model) {

        List<Donation> donationList = donationService.getAllDonationsByOrderByDateAddedDesc();

        model.addAttribute("donationList", donationList);

        return "donations";

    }

    @GetMapping(value = "/myDonations")
    public String myDonations(Model model) {

        List<Donation> myDonations = donationService.getDonationsByAuthenticatedUserOrderByDateAddedDesc();

        model.addAttribute("myDonations", myDonations);

        return "my-donations";

    }

    @GetMapping(value = "/viewProject/{projectId}")
    public String viewProject(@PathVariable int projectId, Model model) {

        ProjectDTO projectDTO = projectService.getProjectById(projectId);
        List<Comment> commentList = commentService.getCommentsByProjectId(projectDTO);
        List<Donation> donationList = donationService.getDonationsByProjectId(projectDTO);

        model.addAttribute("projectDetails", projectDTO);
        model.addAttribute("commentList", commentList);
        model.addAttribute("donationList", donationList);

        return "view-project";

    }

    @GetMapping("/editProject/{projectId}")
    public String showEditProjectForm(@PathVariable("projectId") int projectId, Model model) {

        ProjectDTO projectDTO = projectService.getProjectById(projectId);

        model.addAttribute("projectDetails", projectDTO);

        return "edit-project";

    }

    @PostMapping("/editProject/{projectId}")
    public String editProject(@PathVariable("projectId") int projectId, @ModelAttribute("projectDetails") ProjectDTO newProjectDTO) {

        ProjectDTO oldProjectDTO = projectService.getProjectById(projectId);

        oldProjectDTO.setTitle(newProjectDTO.getTitle());
        oldProjectDTO.setDescription(newProjectDTO.getDescription());

        projectService.updateProject(oldProjectDTO);

        return "redirect:/fundme/controller/web/myProjects";

    }

    @GetMapping(value = "/userProfile")
    public String myProfile(Model model) {
        UserDTO authenticatedUser = userService.getAuthenticatedUser();

        int donationsCount = donationService.getDonationCountByUser(authenticatedUser.getUserId());

        if (donationsCount > 0) {

            int totalDonations = donationService.getTotalDonationsByUser(authenticatedUser.getUserId());
            authenticatedUser.setTotalDonations(totalDonations);

        } else { authenticatedUser.setTotalDonations(0); }

        int projectCount = projectService.getProjectCountByUser(authenticatedUser.getUserId());

        authenticatedUser.setProjectCount(projectCount);
        authenticatedUser.setDonationCount(donationsCount);

        model.addAttribute("authenticatedUser", authenticatedUser);

        return "my-profile";

    }

    @GetMapping(value = "/userProfile/{userId}")
    public String userProfile(@PathVariable int userId, Model model) {

        UserDTO userDTO = userService.getUserWithStats(userId);
        model.addAttribute("user", userDTO);
        return "user-profile";

    }


    @GetMapping("/editProfile/{userId}")
    public String showEditProfileForm(@PathVariable("userId") int userId, Model model) {

        List<CountryDTO> countries = countryService.getAllCountries();
        UserDTO userDTO = userService.getAuthenticatedUser();
        model.addAttribute("countries", countries);
        model.addAttribute("userDetails", userDTO);
        return "edit-profile";
    }

    @PostMapping("/editProfile/{userId}")
    public String editProfile(@PathVariable("userId") int userId, @ModelAttribute("userDetails") UserDTO editedUserDTO) {

        UserDTO existingUserDTO = userService.getUserById(userId);
        existingUserDTO.setName(editedUserDTO.getName());
        existingUserDTO.setCountryId(editedUserDTO.getCountryId());
        existingUserDTO.setEmail(editedUserDTO.getEmail());
        existingUserDTO.setPhone(editedUserDTO.getPhone());
        userService.updateUser(existingUserDTO);
        return "redirect:/fundme/controller/web/userProfile";

    }

    @GetMapping("/confirmDeleteProject/{projectId}")
    public String confirmDeleteProject(@PathVariable("projectId") int projectId, Model model) {

        ProjectDTO projectDTO = projectService.getProjectById(projectId);
        model.addAttribute("project", projectDTO);
        return "confirm-delete-project";

    }

    @PostMapping("/deleteProject/{projectId}")
    public String deleteProject(@PathVariable("projectId") int projectId) {

        ProjectDTO projectDTO = projectService.getProjectById(projectId);

        projectService.deleteProject(projectDTO);

        return "redirect:/fundme/controller/web/myProjects";

    }

    @GetMapping("/confirmDeleteAccount")
    public String confirmDeleteAccount(Model model) {

        UserDTO authenticatedUser = userService.getAuthenticatedUser();

        model.addAttribute("authenticatedUser", authenticatedUser);

        return "confirm-delete-account";
    }

    @PostMapping("/deleteAccount")
    public String deleteAccount() {

        userService.deleteAuthenticatedUser();

        return "redirect:/fundme/controller/web/login";

    }

    @GetMapping(value = "/logout")
    public String logout (HttpServletRequest request) {

        request.getSession().invalidate();

        return "redirect:/fundme/controller/web/login";

    }

    @GetMapping("/notifications")
    public String notifications(Model model) {

        UserDTO authenticatedUser = userService.getUser(new UserDTO());

        List<NotificationDTO> unreadNotifications = notificationService.getUnreadNotificationsByUserOrderByCreatedDateDesc(authenticatedUser);
        List<NotificationDTO> readNotifications = notificationService.getReadNotificationsByUserOrderByCreatedDateDesc(authenticatedUser);

        model.addAttribute("authenticatedUser", authenticatedUser);
        model.addAttribute("unreadNotifications", unreadNotifications);
        model.addAttribute("readNotifications", readNotifications);


        return "notifications";

    }

    @PostMapping("/markNotificationAsRead/{notificationId}")
    public String markNotificationAsRead(@RequestParam("notificationId") int notificationId) {

        notificationService.markNotificationAsRead(notificationId);

        return "redirect:/fundme/controller/web/notifications";

    }

    @GetMapping("/admin")
    @ResponseBody
    public String dashboardAdmin() { return "Welcome to the administration area"; }

    @GetMapping("/accessDenied")
    public String customErrorPage() { return "error"; }

}