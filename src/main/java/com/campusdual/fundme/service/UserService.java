package com.campusdual.fundme.service;

import com.campusdual.fundme.api.IUserService;
import com.campusdual.fundme.model.dao.UserDAO;
import com.campusdual.fundme.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
@Lazy
public class UserService implements IUserService {

    @Autowired
    private UserDAO projectDAO;

    @Override
    public UserDTO queryUser (UserDTO userDTO) { return null; }
    @Override
    public List<UserDTO> queryAllUsers() { return null; }
    @Override
    public int insertUser (UserDTO userDTO) { return 0; }
    @Override
    public int updateUser (UserDTO userDTO) { return 0; }
    @Override
    public int deleteUser (UserDTO userDTO) { return 0; }

}