package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();
    Task addTask(Task task);
    Task getTaskById(Long id);
    Task updateTask(Long id,Task updatedTask);
    Task updateTaskStatus(Long id,String status);
    List<Task> getTasksByStatus(String status);
    List<Task> getTaskByUser(Long id);
}
