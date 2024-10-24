package com.Advatix.LoginApi.dao;

import com.Advatix.LoginApi.entity.User.RolePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolePermissionRepo extends JpaRepository<RolePermission, Long> {
    List<RolePermission> findByRoleId(Long roleId);

    Optional<RolePermission> findById(Long permissionId);
}
