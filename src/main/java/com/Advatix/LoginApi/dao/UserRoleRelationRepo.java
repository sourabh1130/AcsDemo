package com.Advatix.LoginApi.dao;

import com.Advatix.LoginApi.entity.User.UserRole;
import com.Advatix.LoginApi.entity.User.UserRoleRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRelationRepo extends JpaRepository<UserRole, Long> {

    List<UserRoleRelation> findByUserId(Integer userID);

    List<UserRoleRelation> findByUserId(Long uid);
}
