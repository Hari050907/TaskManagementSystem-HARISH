package com.example.taskmanagementsystem.service.impl;

import com.example.taskmanagementsystem.model.TaskStatusLog;
import com.example.taskmanagementsystem.repository.TaskStatusLogRepository;
import com.example.taskmanagementsystem.service.serviceInterface.TaskStatusLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskStatusLogServiceImpl implements TaskStatusLogService {
    @Autowired
    private TaskStatusLogRepository taskLogRepo;

    public TaskStatusLog addLog(TaskStatusLog taskLog){
        return taskLogRepo.save(taskLog);
    }
    public List<TaskStatusLog> getAllLogs(){
        return taskLogRepo.findAll();
    }
    public TaskStatusLog getLogsById(Long id){
        return taskLogRepo.findById(id).orElse(null);
    }
    public List<TaskStatusLog> getLogsByTaskId(Long taskId){
        return taskLogRepo.findByTask_Id(taskId);
    }
    public List<TaskStatusLog> getLogsByOldStatus(String oldStatus){
        return taskLogRepo.findByOldStatus(oldStatus);
    }
}
