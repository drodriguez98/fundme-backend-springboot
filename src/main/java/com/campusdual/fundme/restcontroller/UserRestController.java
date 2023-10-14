package com.campusdual.fundme.restcontroller;

// Este controlador define rutas y métodos que gestionan las solicitudes relacionadas con los usuarios.
// Utiliza el servicio IUserService para llevar a cabo operaciones como consultar, insertar, actualizar y eliminar usuarios.

import com.campusdual.fundme.api.IUserService;
import com.campusdual.fundme.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fundme/controller/rest/users")
public class UserRestController {

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/get")
    public UserDTO queryUser (@RequestBody UserDTO user) { return this.userService.queryUser(user); }

    @GetMapping(value = "/all")
    public List<UserDTO> queryAllUsers() { return this.userService.queryAllUsers(); }

    @PostMapping(value = "add")
    public int insertUser (@RequestBody UserDTO user) { return this.userService.insertUser(user); }

    @PutMapping(value = "/update")
    public int updateUser (@RequestBody UserDTO user) { return this.userService.updateUser(user); }

    @PostMapping(value = "/delete")
    public int deleteUser (@RequestBody UserDTO user) { return this.userService.deleteUser(user); }


}