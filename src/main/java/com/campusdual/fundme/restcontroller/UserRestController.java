package com.campusdual.fundme.restcontroller;

import com.campusdual.fundme.api.IUserService;
import com.campusdual.fundme.config.JwtTokenProvider;
import com.campusdual.fundme.model.AuthResponse;
import com.campusdual.fundme.model.UserCredentials;
import com.campusdual.fundme.model.dto.UserDTO;
import com.campusdual.fundme.service.CustomUserDetailsService;
import com.campusdual.fundme.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@CrossOrigin(maxAge = 3600) // Esta anotación permite el CORS y establece el valor de maxAge
public class UserRestController {

    @Autowired
    private IUserService userService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider; // Inyecta JwtTokenProvider

    @PostMapping(value = "/get")
    public UserDTO queryUser (@RequestBody UserDTO user) { return this.userService.getUser(user); }

    @GetMapping(value = "/all")
    public List<UserDTO> queryAllUsers() { return this.userService.getAllUsers(); }

    @PostMapping(value = "add")
    public int insertUser (@RequestBody UserDTO user) { return this.userService.insertUser(user); }

    @PutMapping(value = "/update")
    public int updateUser (@RequestBody UserDTO user) { return this.userService.updateUser(user); }

    @PostMapping(value = "/delete")
    public int deleteUser (@RequestBody UserDTO user) { return this.userService.deleteUser(user); }

    @PostMapping("/authentication")
    public ResponseEntity<?> authenticate(@RequestBody UserCredentials credentials) {
        try {
            boolean isAuthenticated = loginService.authenticate(credentials.getUsername(), credentials.getPassword());

            if (isAuthenticated) {
                // Obtenemos la información del usuario y sus roles
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(credentials.getUsername());
                List<String> roles = userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList());

                // Generamos el token incluyendo la información del usuario y sus roles
                String token = jwtTokenProvider.generateToken(credentials.getUsername(), roles);

                // Devolvemos el token como parte de la respuesta
                return ResponseEntity.ok(new AuthResponse(token));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}