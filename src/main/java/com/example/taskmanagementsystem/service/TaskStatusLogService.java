package com.example.taskmanagementsystem.service;

import com.example.taskmanagementsystem.model.TaskStatusLog;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TaskStatusLogService {
    TaskStatusLog addLog(TaskStatusLog taskLog);
    List<TaskStatusLog> getAllLogs();
    TaskStatusLog getLogsById(Long id);
    List<TaskStatusLog> getLogsByTaskId(Long taskId);
    List<TaskStatusLog> getLogsByOldStatus(String oldStatus);
}
