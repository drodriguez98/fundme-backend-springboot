package com.campusdual.fundme.restcontroller;

import com.campusdual.fundme.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fundme/controller/rest")
public class LoginRestController {

    @Autowired
    private LoginService loginService; // Inyecta una instancia de LoginService

    // Si el inicio de sesión es exitoso, redirigimos al usuario al panel de control. Si no redirigimos de nuevo a la página de inicio de sesión con un mensaje de error.

    @PostMapping("/authentication")
    public String authenticate(@RequestParam String username, @RequestParam String password) {

        boolean isAuthenticated = loginService.authenticate(username, password);

        // Autenticación exitosa redirige al panel de control. Autenticacion fallida puede redirigir a login con mensaje de error o a una página de error.

        if (isAuthenticated) {

            return "redirect:/fundme/controller/web/dashboard";

        } else {

            return "redirect:/fundme/controller/web/login";

            // return "redirect:/api/public/showLoginForm?error=true";

        }

    }

}