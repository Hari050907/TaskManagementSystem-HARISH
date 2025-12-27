package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.model.Task;
import com.example.taskmanagementsystem.model.User;
import com.example.taskmanagementsystem.repository.TaskRepository;
import com.example.taskmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task addTask(Task task) {
        if(task.getCreatedBy() == null || task.getCreatedBy().getId() == null){
            return null;
        }
        User user = userRepository.findById(task.getCreatedBy().getId()).orElse(null);
        if(user == null){
            return null;
        }
        task.setCreatedBy(user);
        return taskRepository.save(task);
    }
    @Override
    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }
    @Override
    public Task updateTask(Long id, Task updatedTask) {
        Task existingTask = taskRepository.findById(id).orElse(null);
        if(existingTask != null){
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setPriority(updatedTask.getPriority());
            existingTask.setDueDate(updatedTask.getDueDate());
            existingTask.setStatus(updatedTask.getStatus());
            existingTask.setCreatedBy(updatedTask.getCreatedBy());
            taskRepository.save(existingTask);
        }
        return existingTask;
    }
    @Override
    public Task updateTaskStatus(Long id,String status){
        Task existing = taskRepository.findById(id).orElse(null);
        if(existing != null){
            existing.setStatus(status);
            return taskRepository.save(existing);
        }
        return null;
    }
    @Override
    public List<Task> getTasksByStatus(String status){
        return taskRepository.findByStatus(status);
    }
    @Override
    public List<Task> getTaskByUser(Long id){
        return taskRepository.findByCreatedById(id);
    }
}
