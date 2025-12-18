package com.example.taskmanagementsystem.controller;

import com.example.taskmanagementsystem.model.User;
import com.example.taskmanagementsystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        User user1 = userServiceImpl.addUserToDb(user);
        if(user1 == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(user1);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userServiceImpl.getAllUsers();
        if(users == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

}
