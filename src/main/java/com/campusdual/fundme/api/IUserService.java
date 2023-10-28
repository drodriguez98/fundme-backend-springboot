package com.campusdual.fundme.api;

import com.campusdual.fundme.model.dto.UserDTO;
import java.util.List;

public interface IUserService {

    UserDTO getUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();

    int insertUser (UserDTO userDTO);
    int updateUser (UserDTO userDTO);
    int deleteUser (UserDTO userDTO);

    UserDTO getUserById(int userId);
    UserDTO getAuthenticatedUser();
    void deleteAuthenticatedUser();

}