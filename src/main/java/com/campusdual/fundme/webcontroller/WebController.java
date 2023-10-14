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
    public String welcomeToDashboard() { return "dashboard"; }

}