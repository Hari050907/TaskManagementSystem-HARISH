package com.example.taskmanagementsystem.service.impl;

import com.example.taskmanagementsystem.exception.ResourceNotFoundException;
import com.example.taskmanagementsystem.model.User;
import com.example.taskmanagementsystem.repository.UserRepository;
import com.example.taskmanagementsystem.service.serviceInterface.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;

    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepo.findAll();
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("No users found");
        }
        return users;
    }

    @Override
    public User getUserbyId(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
    }

    @Override
    public User updateUser(Long id, User user) {
        User existing = getUserbyId(id);

        existing.setName(user.getName());
        existing.setEmail(user.getEmail());
        existing.setRole(user.getRole());

        return userRepo.save(existing);
    }

    @Override
    public Page<User> getUsersWithPagination(int page, int size) {
        return userRepo.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<User> getUsersByRoles(String role) {
        List<User> users = userRepo.findByRole(role);
        if (users.isEmpty()) {
            throw new ResourceNotFoundException("No users found with role " + role);
        }
        return users;
    }
}
