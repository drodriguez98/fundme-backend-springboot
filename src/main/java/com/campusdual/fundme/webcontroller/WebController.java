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
@RequestMapping("")
public class WebController {

    @Autowired
    private IUserService userService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private IProjectService projectService;

    @Autowired
    private INotificationService notificationService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping(value = "/userProfile/{userId}")
    public String userProfile(@PathVariable int userId, Model model) {

        UserDTO userDTO = userService.getUserWithStats(userId);
        model.addAttribute("user", userDTO);
        return "user-profile";

    }

    @GetMapping(value = "/logout")
    public String logout (HttpServletRequest request) {

        request.getSession().invalidate();

        return "redirect:/login";

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

        return "redirect:/notifications";

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

    @GetMapping("/admin")
    @ResponseBody
    public String dashboardAdmin() { return "Welcome to the administration area"; }

    @GetMapping("/accessDenied")
    public String customErrorPage() { return "error"; }

}