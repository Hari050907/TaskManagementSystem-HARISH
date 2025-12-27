package com.example.taskmanagementsystem.service;


import com.example.taskmanagementsystem.model.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    User addUser(User user);
    List<User> getAllUsers();
    User getUserbyId(Long id);
    User updateUser(Long id, User user);
    Page<User> getUsersWithPagination(int page, int size);
    List<User> getUsersByRoles(String role);
}
