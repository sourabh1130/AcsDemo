package com.Advatix.LoginApi.controller;

import com.Advatix.LoginApi.service.UserService.UserService;
import com.Advatix.LoginApi.service.UserService.UserRoleService;
import com.Advatix.LoginApi.service.UserService.UserRoleRelationService;
import com.Advatix.LoginApi.service.UserService.PermissionService;
import com.Advatix.LoginApi.service.UserService.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController1 {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserRoleRelationService userRoleRelationService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RolePermissionService rolePermissionService;

//    @PostMapping("/login")
//    public String login(@RequestBody Login login) {
//        Long id = login.getId();
//        String password = login.getPassword();
//        Optional<UserDto> list = userService.getUserById(id);  // Assuming you have this method in UserService
//        System.out.println(list.get());
//        if (password.equals(list.get())) {
//            return "Successfully Login";
//        }
//
//        return "SORRY PASSWORD IS WRONG";
//    }
}

