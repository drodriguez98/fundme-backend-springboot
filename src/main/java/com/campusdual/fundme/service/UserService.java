package com.campusdual.fundme.service;

import com.campusdual.fundme.api.IUserService;
import com.campusdual.fundme.model.repository.UserRepository;
import com.campusdual.fundme.model.dto.UserDTO;
import com.campusdual.fundme.model.User;
import com.campusdual.fundme.model.dto.dtopmapper.UserMapper;

import com.campusdual.fundme.util.PasswordEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service("UserService")
@Lazy
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoderUtil passwordEncoderUtil;

    @Override
    public UserDTO getUser(UserDTO userDTO) {

        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByUsername(authenticatedUsername);

        return UserMapper.INSTANCE.toDTO(user);

    }

    @Override
    public List<UserDTO> getAllUsers() { return UserMapper.INSTANCE.toDTOList(userRepository.findAll()); }

    @Override
    public int insertUser (UserDTO userDTO) {

        User user = UserMapper.INSTANCE.toEntity(userDTO);

        user.setDate_added(new Date());

        user.setActive(true);
        user.setAdmin(false);

        String hashedPassword = passwordEncoderUtil.encodePassword(user.getPassword());
        user.setPassword(hashedPassword);

        this.userRepository.saveAndFlush(user);

        return user.getUserId();

    }

    @Override
    public int updateUser (UserDTO userDTO) { return this.insertUser(userDTO); }

    @Override
    public int deleteUser (UserDTO userDTO) {

        int id = userDTO.getUserId();
        User user = UserMapper.INSTANCE.toEntity(userDTO);
        this.userRepository.delete(user);
        return id;

    }

}