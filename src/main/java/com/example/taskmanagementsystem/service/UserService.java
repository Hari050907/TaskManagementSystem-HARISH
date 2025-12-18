package com.example.taskmanagementsystem.service;


import com.example.taskmanagementsystem.model.User;

import java.util.List;

public interface UserService {
    User addUserToDb(User user);
    List<User> getAllUsers();
    User getUserById(Long id);
}
