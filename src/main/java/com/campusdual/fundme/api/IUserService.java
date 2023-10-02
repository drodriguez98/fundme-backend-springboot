package com.campusdual.fundme.api;

import com.campusdual.fundme.model.dto.UserDTO;
import java.util.List;

public interface IUserService {

    UserDTO queryUser (UserDTO userDTO);
    List<UserDTO> queryAllUsers();
    int insertUser (UserDTO userDTO);
    int updateUser (UserDTO userDTO);
    int deleteUser (UserDTO userDTO);

}