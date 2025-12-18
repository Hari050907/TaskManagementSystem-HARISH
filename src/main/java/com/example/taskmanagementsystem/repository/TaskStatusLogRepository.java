package com.example.taskmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.taskmanagementsystem.model.TaskStatusLog;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskStatusLogRepository extends JpaRepository<TaskStatusLog,Long> {
}
