package com.campusdual.fundme.service;

// Esta clase implementa la interfaz IUserService y proporciona la lógica de negocio para manejar operaciones relacionadas con usuarios.
// Se encarga de transformar objetos UserDTO en objetos User y viceversa.
// Utiliza un servicio para codificar contraseñas antes de almacenarlas en la base de datos.

import com.campusdual.fundme.api.IUserService;
import com.campusdual.fundme.model.dao.UserRepository;
import com.campusdual.fundme.model.dto.UserDTO;
import com.campusdual.fundme.model.User;
import com.campusdual.fundme.model.dto.dtopmapper.UserMapper;
import com.campusdual.fundme.util.PasswordEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("UserService")
@Lazy
public class UserService implements IUserService {

    @Autowired
    private UserRepository userDAO;

    // Inyecta el utilitario de codificación de contraseñas

    @Autowired
    private PasswordEncoderUtil passwordEncoderUtil;

    @Override
    public UserDTO queryUser(UserDTO userDTO) {
        // Obtiene el nombre de usuario del usuario autenticado desde el contexto de seguridad
        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();

        // Utiliza el nombre de usuario para buscar al usuario autenticado en el repositorio
        User user = userDAO.findByUsername(authenticatedUsername);

        // Convierte el usuario en UserDTO y lo devuelve
        return UserMapper.INSTANCE.toDTO(user);
    }


    @Override
    public List<UserDTO> queryAllUsers() { return UserMapper.INSTANCE.toDTOList(userDAO.findAll()); }

    @Override
    public int insertUser (UserDTO userDTO) {

        User user = UserMapper.INSTANCE.toEntity(userDTO);

        // Genera un hash BCrypt para la contraseña antes de almacenarla

        String hashedPassword = passwordEncoderUtil.encodePassword(user.getPassword());
        user.setPassword(hashedPassword);

        this.userDAO.saveAndFlush(user);
        return user.getUser_id();

    }

    @Override
    public int updateUser (UserDTO userDTO) { return this.insertUser(userDTO); }

    @Override
    public int deleteUser (UserDTO userDTO) {

        int id = userDTO.getUser_id();
        User user = UserMapper.INSTANCE.toEntity(userDTO);
        this.userDAO.delete(user);
        return id;

    }

}