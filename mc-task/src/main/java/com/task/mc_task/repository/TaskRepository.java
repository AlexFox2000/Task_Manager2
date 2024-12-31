package com.task.mc_task.repository;

import com.task.mc_task.entity.Status;
import com.task.mc_task.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository <Task, Long> {
    public List <Task> findByStatus (Status status);
}
