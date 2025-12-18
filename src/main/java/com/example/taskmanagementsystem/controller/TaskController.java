package com.example.taskmanagementsystem.controller;

import com.example.taskmanagementsystem.model.Task;
import com.example.taskmanagementsystem.service.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskServiceImpl taskServiceImpl;

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskServiceImpl.getAllTasks();
        if(tasks == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tasks);
    }
    @PostMapping
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        Task task1 = taskServiceImpl.addTask(task);
        if(task1 == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(task1);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Task tsk = taskServiceImpl.getTaskById(id);
        if(tsk == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(tsk);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTaskById(@PathVariable Long id,@RequestBody Task updatedTask){
        Task updatedTsk = taskServiceImpl.updateTask(id,updatedTask);
        if(updatedTsk == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedTsk);
    }
}
