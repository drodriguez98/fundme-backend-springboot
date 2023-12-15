package com.campusdual.fundme.service;

import com.campusdual.fundme.api.IUserService;
import com.campusdual.fundme.model.repository.ProjectRepository;
import com.campusdual.fundme.model.repository.UserRepository;
import com.campusdual.fundme.model.dto.UserDTO;
import com.campusdual.fundme.model.User;
import com.campusdual.fundme.model.dto.dtopmapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service("UserService")
@Lazy
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private DonationService donationService;

    @Override
    public UserDTO getUser(UserDTO userDTO) {

        User user = UserMapper.INSTANCE.toEntity(userDTO);

        return UserMapper.INSTANCE.toDTO(this.userRepository.getReferenceById(user.getUserId()));

    }

    @Override
    public UserDTO getAuthenticatedUser(UserDTO userDTO) {

        String authenticatedUsername = SecurityContextHolder.getContext().getAuthentication().getName();

        User user = userRepository.findByUsername(authenticatedUsername);

        return UserMapper.INSTANCE.toDTO(user);

    }

    @Override
    public UserDTO getUserById(int userId) {

        User user = userRepository.getReferenceById(userId);

        return UserMapper.INSTANCE.toDTO(user);

    }

    @Override
    public UserDTO getAuthenticatedUser() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null) { throw new RuntimeException("Ningún usuario autenticado."); }

        String username = authentication.getName();
        User authenticatedUser = userRepository.findByUsername(username);

        if (authenticatedUser == null) { throw new RuntimeException("Usuario autenticado no encontrado."); }

        return UserMapper.INSTANCE.toDTO(authenticatedUser);
    }

    @Override
    public UserDTO getAuthenticatedUserWithStats(UserDTO authenticatedUser) {



        int donationsCount = donationService.getDonationCountByUser(authenticatedUser.getUserId());

        int totalDonations = 0;

        if (donationsCount > 0) { totalDonations = donationService.getTotalDonationsByUser(authenticatedUser.getUserId()); }

        authenticatedUser.setTotalDonations(totalDonations);
        authenticatedUser.setProjectCount(projectService.getProjectCountByUser(authenticatedUser.getUserId()));
        authenticatedUser.setDonationCount(donationsCount);

        return authenticatedUser;

    }


    @Override
    public UserDTO getUserWithStats(int userId) {

        User user = userRepository.getReferenceById(userId);
        UserDTO userDTO = UserMapper.INSTANCE.toDTO(user);

        int donationsCount = donationService.getDonationCountByUser(userId);

        int totalDonations = 0;

        if (donationsCount > 0) { totalDonations = donationService.getTotalDonationsByUser(userId); }

        userDTO.setTotalDonations(totalDonations);
        userDTO.setProjectCount(projectService.getProjectCountByUser(userId));
        userDTO.setDonationCount(donationsCount);

        return userDTO;

    }

    @Override
    public List<UserDTO> getAllUsers() { return UserMapper.INSTANCE.toDTOList(userRepository.findAll()); }

    @Override
    public int insertUser (UserDTO userDTO) {

        User user = UserMapper.INSTANCE.toEntity(userDTO);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(user.getPassword());

        user.setPassword(hashedPassword);
        user.setDateAdded(new Date());
        user.setActive(true);
        user.setAdmin(false);

        this.userRepository.saveAndFlush(user);

        return user.getUserId();

    }

    @Override
    public int updateUser (UserDTO userDTO) {

        User user = UserMapper.INSTANCE.toEntity(userDTO);

        this.userRepository.saveAndFlush(user);

        return user.getUserId();

    }

    @Override
    public int deleteUser (UserDTO userDTO) {

        int userId = userDTO.getUserId();
        User user = UserMapper.INSTANCE.toEntity(userDTO);

        this.userRepository.delete(user);

        return userId;

    }

    @Override
    public void deleteAuthenticatedUser() {

        UserDTO authenticatedUser = getAuthenticatedUser();
        userRepository.delete(UserMapper.INSTANCE.toEntity(authenticatedUser));

    }

}