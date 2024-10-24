package com.Advatix.LoginApi.service.UserService;

import com.Advatix.LoginApi.entity.User.RolePermission;
import com.Advatix.LoginApi.dao.RolePermissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolePermissionService {
    @Autowired
    private RolePermissionRepo rolePermissionRepo;

    public Optional<RolePermission> findById(Long permissionId) {
        return rolePermissionRepo.findById(permissionId);
    }

    public List<RolePermission> findByRoleId(Long roleId) {
        // Assuming there's a method in the repo to find by roleId
        return rolePermissionRepo.findByRoleId(roleId);
    }
}
