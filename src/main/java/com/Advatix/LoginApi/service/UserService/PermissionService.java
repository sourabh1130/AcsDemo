package com.Advatix.LoginApi.service.UserService;

import com.Advatix.LoginApi.entity.User.Permission;
import com.Advatix.LoginApi.dao.PermissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PermissionService {
    @Autowired
    private PermissionRepo permissionRepo;

    public Optional<Permission> findById(Long permissionId) {
        return permissionRepo.findById(permissionId);
    }
}
