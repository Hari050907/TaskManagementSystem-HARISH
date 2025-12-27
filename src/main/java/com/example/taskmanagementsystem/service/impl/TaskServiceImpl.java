package com.example.taskmanagementsystem.service.impl;

import com.example.taskmanagementsystem.exception.ResourceNotFoundException;
import com.example.taskmanagementsystem.model.Task;
import com.example.taskmanagementsystem.model.User;
import com.example.taskmanagementsystem.repository.TaskRepository;
import com.example.taskmanagementsystem.repository.UserRepository;
import com.example.taskmanagementsystem.service.serviceInterface.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        if (tasks.isEmpty()) {
            throw new ResourceNotFoundException("No tasks found");
        }
        return tasks;
    }

    @Override
    public Task addTask(Task task) {
        if (task.getCreatedBy() == null || task.getCreatedBy().getId() == null) {
            throw new ResourceNotFoundException("User ID is required to create a task");
        }

        User user = userRepository.findById(task.getCreatedBy().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        task.setCreatedBy(user);
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + id));
    }

    @Override
    public Task updateTask(Long id, Task updatedTask) {
        Task existing = getTaskById(id);

        existing.setTitle(updatedTask.getTitle());
        existing.setDescription(updatedTask.getDescription());
        existing.setPriority(updatedTask.getPriority());
        existing.setDueDate(updatedTask.getDueDate());
        existing.setStatus(updatedTask.getStatus());

        return taskRepository.save(existing);
    }

    @Override
    public Task updateTaskStatus(Long id, String status) {
        Task task = getTaskById(id);
        task.setStatus(status);
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getTasksByStatus(String status) {
        List<Task> tasks = taskRepository.findByStatus(status);
        if (tasks.isEmpty()) {
            throw new ResourceNotFoundException("No tasks found with status: " + status);
        }
        return tasks;
    }

    public List<Task> getTaskByUser(Long userId) {
        List<Task> tasks = taskRepository.findByCreatedById(userId);
        if (tasks.isEmpty()) {
            throw new ResourceNotFoundException("No tasks found for user id " + userId);
        }
        return tasks;
    }
}
