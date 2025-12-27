package com.example.taskmanagementsystem.controller;

import com.example.taskmanagementsystem.exception.ResourceNotFoundException;
import com.example.taskmanagementsystem.model.TaskStatusLog;
import com.example.taskmanagementsystem.service.impl.TaskStatusLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task-logs")
public class TaskStatusLogController {

    @Autowired
    private TaskStatusLogServiceImpl taskLogService;

    @PostMapping
    public ResponseEntity<TaskStatusLog> addLog(@RequestBody TaskStatusLog log) {
        TaskStatusLog saved = taskLogService.addLog(log);
        if (saved == null) {
            throw new ResourceNotFoundException("Failed to create task log");
        }
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskStatusLog>> getAllLogs() {
        List<TaskStatusLog> logs = taskLogService.getAllLogs();
        if (logs.isEmpty()) {
            throw new ResourceNotFoundException("No task logs found");
        }
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskStatusLog> getLogById(@PathVariable Long id) {
        TaskStatusLog log = taskLogService.getLogsById(id);
        if (log == null) {
            throw new ResourceNotFoundException("Task log not found with id " + id);
        }
        return ResponseEntity.ok(log);
    }

    @GetMapping("/task/{taskId}")
    public ResponseEntity<List<TaskStatusLog>> getLogsByTask(@PathVariable Long taskId) {
        List<TaskStatusLog> logs = taskLogService.getLogsByTaskId(taskId);
        if (logs.isEmpty()) {
            throw new ResourceNotFoundException("No logs found for task " + taskId);
        }
        return ResponseEntity.ok(logs);
    }

    @GetMapping("/old/{oldStatus}")
    public ResponseEntity<List<TaskStatusLog>> getLogsByOldStatus(@PathVariable String oldStatus) {
        List<TaskStatusLog> logs = taskLogService.getLogsByOldStatus(oldStatus);
        if (logs.isEmpty()) {
            throw new ResourceNotFoundException("No logs found with old status " + oldStatus);
        }
        return ResponseEntity.ok(logs);
    }
}
