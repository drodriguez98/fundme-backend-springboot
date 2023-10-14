package com.campusdual.fundme.controller;

import com.campusdual.fundme.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/public")
public class LoginController {

    @Autowired
    private LoginService loginService; // Inyecta una instancia de LoginService

    // Redirige a la página de inicio de sesión (signin.html)

    @GetMapping("/showLoginForm")
    public String loginPage() { return "signin"; }

    // Si el inicio de sesión es exitoso, redirigimos al usuario al panel de control. Si no redirigimos de nuevo a la página de inicio de sesión con un mensaje de error.

    @PostMapping("/authentication")
    public String authenticate(@RequestParam String username, @RequestParam String password) {

        boolean isAuthenticated = loginService.authenticate(username, password);

        // Autenticación exitosa redirige al panel de control. Autenticacion fallida puede redirigir a login con mensaje de error o a una página de error.

        if (isAuthenticated) {

            return "redirect:/api/private/users/dashboard";

        } else {

            return "redirect:/api/public/error";

            // return "redirect:/api/public/showLoginForm?error=true";

        }

    }

}