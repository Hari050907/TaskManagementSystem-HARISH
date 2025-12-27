package com.example.taskmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.taskmanagementsystem.model.TaskStatusLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskStatusLogRepository extends JpaRepository<TaskStatusLog,Long> {
    List<TaskStatusLog> findByTask_Id(Long taskId);
    List<TaskStatusLog> findByOldStatus(String oldStatus);
}
