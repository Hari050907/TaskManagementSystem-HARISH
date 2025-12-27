package com.example.taskmanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.taskmanagementsystem.model.TaskAssignment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskAssignmentRepository extends JpaRepository<TaskAssignment,Long> {
    List<TaskAssignment> findByUser_Id(Long userId);
}
