package com.Advatix.LoginApi.controller;

import com.Advatix.LoginApi.dto.UserDto;
import com.Advatix.LoginApi.entity.Client.ClientEntity;
import com.Advatix.LoginApi.entity.User.User;
import com.Advatix.LoginApi.service.ClientService.ClientService;
import com.Advatix.LoginApi.service.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ClientService clientService;

    @PostMapping("/addClient")

    public ResponseEntity<ClientEntity> createClient(@RequestBody ClientEntity clientEntity){
        ClientEntity client=clientService.createClient(clientEntity);
        return ResponseEntity.ok(client);
    }
    @GetMapping("/get")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<User> createUser(@RequestBody UserDto userDTO) {
        User user=userService.createUser(userDTO);
        return ResponseEntity.ok(user);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDto userDTO) {
        User user=userService.updateUser(id, userDTO);

        return ResponseEntity.ok(user);
    }



}
