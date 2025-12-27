package com.example.taskmanagementsystem.controller;

import com.example.taskmanagementsystem.exception.ResourceNotFoundException;
import com.example.taskmanagementsystem.model.Task;
import com.example.taskmanagementsystem.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskServiceImpl taskService;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        if (tasks.isEmpty()) {
            throw new ResourceNotFoundException("No tasks found");
        }
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        Task saved = taskService.addTask(task);
        if (saved == null) {
            throw new ResourceNotFoundException("Task creation failed");
        }
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = taskService.getTaskById(id);
        if (task == null) {
            throw new ResourceNotFoundException("Task not found with id " + id);
        }
        return ResponseEntity.ok(task);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Task> updateTaskStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        Task updated = taskService.updateTaskStatus(id, status);
        if (updated == null) {
            throw new ResourceNotFoundException("Task not found with id " + id);
        }
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable String status) {
        List<Task> tasks = taskService.getTasksByStatus(status);
        if (tasks.isEmpty()) {
            throw new ResourceNotFoundException("No tasks found with status " + status);
        }
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Task>> getTasksByUser(@PathVariable Long id) {
        List<Task> tasks = taskService.getTaskByUser(id);
        if (tasks.isEmpty()) {
            throw new ResourceNotFoundException("No tasks found for user " + id);
        }
        return ResponseEntity.ok(tasks);
    }
}
