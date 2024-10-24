package com.Advatix.LoginApi.dao;

import com.Advatix.LoginApi.dto.UserDto;
import com.Advatix.LoginApi.entity.User.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    List<String> findByUid(Long uid);


    @Query("SELECT u FROM User u JOIN Client c ON u.clientId = c.id "
            + "JOIN City ct ON u.cityId = ct.id "
            + "JOIN State s ON ct.stateId = s.id "
            + "JOIN Country cn ON s.countryId = cn.id "
            + "JOIN Role r ON u.roleId = r.id")
    default List<UserDto> findAllUsers() {
        return null;

    }

//    @Query("SELECT u FROM User u JOIN Client c ON u.clientId = c.id JOIN City ct ON u.cityId = ct.id "
//            + "JOIN State s ON ct.stateId = s.id JOIN Country cn ON s.countryId = cn.id "
//            + "JOIN Role r ON u.roleId = r.id WHERE u.id = :id")
//    Optional<UserDto> findUserById(@Param("id") Long id);

//     List<User> findAll();



}
