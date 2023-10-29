package com.campusdual.fundme.api;

import com.campusdual.fundme.model.dto.UserDTO;
import java.util.List;

public interface IUserService {

    UserDTO getUser(UserDTO userDTO);
    UserDTO getUserById(int userId);
    UserDTO getAuthenticatedUser();

    List<UserDTO> getAllUsers();

    int insertUser (UserDTO userDTO);
    int updateUser (UserDTO userDTO);
    int deleteUser (UserDTO userDTO);

    void deleteAuthenticatedUser();

}