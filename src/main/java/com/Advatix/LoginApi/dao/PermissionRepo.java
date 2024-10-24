package com.Advatix.LoginApi.dao;

import com.Advatix.LoginApi.entity.User.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepo extends JpaRepository<Permission, Long> {
}
