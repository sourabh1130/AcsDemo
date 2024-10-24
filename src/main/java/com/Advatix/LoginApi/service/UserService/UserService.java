package com.Advatix.LoginApi.service.UserService;

import com.Advatix.LoginApi.dao.*;
import com.Advatix.LoginApi.dao.ClientDao.CityRepo;
import com.Advatix.LoginApi.dao.ClientDao.ClientRepo;
import com.Advatix.LoginApi.entity.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Advatix.LoginApi.dto.UserDto;
import java.util.List;
import java.util.Optional;



@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private ClientRepo clientRepository;

    @Autowired
    private CityRepo cityRepository;

    @Autowired
    private UserRoleRepo roleRepository;

    public List<User> getAllUsers() {
        // Fetch all users and join the related tables (client, role, city, state, country)
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        // Fetch user by ID with the necessary joins
        return userRepository.findById(id);
//        return userRepository.findUserById(id);
    }

    public User createUser(UserDto userDto) {
        // Create a new user
        User user = new User();
        user.setUName(user.getUName());
        user.setMail(userDto.getMail());
        user.setPassword(userDto.getPassword());
        user.setClientId(userDto.getClientId());
        user.setCityID(userDto.getCityId());
        user.setRoleId(userDto.getRoleId());
        user.setPNo(userDto.getPNo());
        user.setStatus(userDto.getStatus());
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public User updateUser(Long id, UserDto userDto) {
        // Update user details
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();

            user.setUName(userDto.getUName());
            user.setMail(userDto.getMail());
            user.setPassword(userDto.getPassword());
            user.setClientId(userDto.getClientId());
            user.setCityID(userDto.getCityId());
            user.setRoleId(userDto.getRoleId());
            user.setPNo(userDto.getPNo());
            user.setStatus(userDto.getStatus());

            User updatedUser = userRepository.save(user);
//            return ResponseEntity.ok(new UserDto(updatedUser));

            return updatedUser;
        }else{
            return null;
        }
    }


}

