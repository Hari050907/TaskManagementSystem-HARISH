package com.example.taskmanagementsystem.controller;

import com.example.taskmanagementsystem.exception.ResourceNotFoundException;
import com.example.taskmanagementsystem.model.TaskAssignment;
import com.example.taskmanagementsystem.service.TaskAssignmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assignments")
public class TaskAssignmentController {

    @Autowired
    private TaskAssignmentServiceImpl taskAssignmentService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<TaskAssignment>> getAssignmentsByUserId(@PathVariable Long userId) {
        List<TaskAssignment> tasks = taskAssignmentService.getAssignmentsByUserId(userId);
        if (tasks.isEmpty()) {
            throw new ResourceNotFoundException("No assignments found for user id " + userId);
        }
        return ResponseEntity.ok(tasks);
    }
}
