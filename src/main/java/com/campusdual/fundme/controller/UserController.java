package com.campusdual.fundme.controller;

import com.campusdual.fundme.api.IUserService;
import com.campusdual.fundme.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/private/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/get")
    public UserDTO queryUser (@RequestBody UserDTO user) { return this.userService.queryUser(user); }

    @GetMapping(value = "/all")
    public List<UserDTO> queryAllUsers() { return this.userService.queryAllUsers(); }

    @PostMapping(value = "/add")
    public int insertUser (@RequestBody UserDTO user) { return this.userService.insertUser(user); }

    @PutMapping(value = "/update")
    public int updateUser (@RequestBody UserDTO user) { return this.userService.updateUser(user); }

    @PostMapping(value = "/delete")
    public int deleteUser (@RequestBody UserDTO user) { return this.userService.deleteUser(user); }

}