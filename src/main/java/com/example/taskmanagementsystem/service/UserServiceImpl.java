package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.model.User;
import com.example.taskmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepo;

    public User addUser(User user){
        return userRepo.save(user);
    }
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    public User getUserbyId(Long id){
        return userRepo.findById(id).orElse(null);
    }
    public User updateUser(Long id,User user){
        User existingUser = userRepo.findById(id).orElse(null);
        if(existingUser != null){
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setRole(user.getRole());
            userRepo.save(existingUser);
        }
        return existingUser;
    }
    public Page<User> getUsersWithPagination(int page, int size){
        PageRequest pageable = PageRequest.of(page,size);
        return userRepo.findAll(pageable);
    }

    public List<User> getUsersByRoles(String role){
        return userRepo.findByRole(role);
    }
}
