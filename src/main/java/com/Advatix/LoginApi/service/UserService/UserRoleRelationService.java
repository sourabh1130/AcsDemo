package com.Advatix.LoginApi.service.UserService;

import com.Advatix.LoginApi.entity.User.UserRole;
import com.Advatix.LoginApi.entity.User.UserRoleRelation;
import com.Advatix.LoginApi.dao.UserRoleRelationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleRelationService {
    @Autowired
    private UserRoleRelationRepo userRoleRelationRepo;

    public Optional<UserRole> findById(Long id) {
        return userRoleRelationRepo.findById((id));
    }

    public List<UserRoleRelation> findByUserId(Integer userID) {
        // Assuming there's a method in the repo to find by userId
        return userRoleRelationRepo.findByUserId(userID);
    }

    public List<UserRoleRelation> findByUserId(Long userId) {
        return userRoleRelationRepo.findByUserId(userId);
    }
}
