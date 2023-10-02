package com.campusdual.fundme.service;

import com.campusdual.fundme.api.IUserService;
import com.campusdual.fundme.model.dao.UserDAO;
import com.campusdual.fundme.model.dto.UserDTO;
import com.campusdual.fundme.model.User;
import com.campusdual.fundme.model.dto.dtopmapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("UserService")
@Lazy
public class UserService implements IUserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDTO queryUser (UserDTO userDTO) {

        User user = UserMapper.INSTANCE.toEntity(userDTO);
        return UserMapper.INSTANCE.toDTO(this.userDAO.getReferenceById(user.getUser_id()));

    }

    @Override
    public List<UserDTO> queryAllUsers() {

        return UserMapper.INSTANCE.toDTOList(userDAO.findAll());

    }

    @Override
    public int insertUser (UserDTO userDTO) {

        User user = UserMapper.INSTANCE.toEntity(userDTO);
        this.userDAO.saveAndFlush(user);
        return user.getUser_id();

    }

    @Override
    public int updateUser (UserDTO userDTO) {

        return this.insertUser(userDTO);

    }

    @Override
    public int deleteUser (UserDTO userDTO) {

        int id = userDTO.getUser_id();
        User user = UserMapper.INSTANCE.toEntity(userDTO);
        this.userDAO.delete(user);
        return id;

    }

}