package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.model.TaskAssignment;
import com.example.taskmanagementsystem.repository.TaskAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskAssignmentServiceImpl {
    @Autowired
    TaskAssignmentRepository taskAssignmentRepo;


    public List<TaskAssignment> getAssignmentsByUserId(Long userId){
        return taskAssignmentRepo.findByUser_Id(userId);
    }
}
