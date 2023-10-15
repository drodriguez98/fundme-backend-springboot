package com.campusdual.fundme.webcontroller;

import com.campusdual.fundme.api.IUserService;
import com.campusdual.fundme.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fundme/controller/web")
public class WebController {

    @Autowired
    private IUserService userService;

    @Autowired
    private LoginService loginService; // Inyecta una instancia de LoginService

    // Redirige a la página de inicio de sesión (login.html)

    @GetMapping("/login")
    public String loginPage() { return "login"; }

    @GetMapping(value = "/dashboard")
    public String dashboard() { return "dashboard"; }

    @GetMapping(value = "/createProject")
    public String creatProject() { return "create-project"; }

    @GetMapping(value = "/donations")
    public String donations() { return "donations"; }

    @GetMapping(value = "/myDonations")
    public String myDonations() { return "my-donations"; }

    @GetMapping(value = "/userProfile")
    public String userProfile() { return "user-profile"; }

    @GetMapping(value = "/viewProject")
    public String viewProject() { return "view-project"; }

    @GetMapping(value = "/myProjects")
    public String myProjects() { return "my-projects"; }

    @GetMapping(value = "/allProjects")
    public String allProjects() { return "all-projects"; }

    @GetMapping(value = "/settings")
    public String settings() { return "settings"; }

    @GetMapping(value = "/logout")
    public String logout() { return "logout"; }

}