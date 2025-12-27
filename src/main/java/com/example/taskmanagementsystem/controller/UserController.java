package com.example.taskmanagementsystem.controller;

import com.example.taskmanagementsystem.exception.BadRequestException;
import com.example.taskmanagementsystem.exception.ResourceNotFoundException;
import com.example.taskmanagementsystem.model.User;
import com.example.taskmanagementsystem.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User saved = userService.addUser(user);
        if (saved == null) {
            throw new BadRequestException("Failed to create user");
        }
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("No users found");
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserbyId(id);
        if (user == null) {
            throw new ResourceNotFoundException("User not found with id " + id);
        }
        return ResponseEntity.ok(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
        User updated = userService.updateUser(id, user);
        if (updated == null) {
            throw new ResourceNotFoundException("User not found with id " + id);
        }
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<User>> getUsersWithPagination(
            @PathVariable int page,
            @PathVariable int size) {

        Page<User> users = userService.getUsersWithPagination(page, size);
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("No users found");
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable String role) {
        List<User> users = userService.getUsersByRoles(role);
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("No users found with role " + role);
        }
        return ResponseEntity.ok(users);
    }
}
