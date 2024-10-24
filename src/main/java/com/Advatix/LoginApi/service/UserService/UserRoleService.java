package com.Advatix.LoginApi.service.UserService;

import com.Advatix.LoginApi.entity.User.UserRole;
import com.Advatix.LoginApi.dao.UserRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepo userRoleRepo;

    public Optional<UserRole> findById(Long id) {
        return userRoleRepo.findById(id);
    }
}
