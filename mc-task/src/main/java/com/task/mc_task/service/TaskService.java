package com.task.mc_task.service;


import com.task.mc_task.entity.Status;
import com.task.mc_task.entity.Task;
import com.task.mc_task.repository.TaskRepository;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class TaskService {

    private final TaskRepository taskRepository;

    public Task createdNewTask (Task task){
        return taskRepository.save(task);
    }

    public Task getTaskById (Long id){
        return taskRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Task with id " + id + " not found."));
    }

    public List<Task> getAllTasks (){
        return taskRepository.findAll();
    }

    public List <Task>  getTaskByFilter (Status status){
        return taskRepository.findByStatus(status);
    }

    public Task updatedTask (Task updatedTask, Long id){
        Task exist = taskRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("This task with id " + id + " not found."));
        exist.setTitle(updatedTask.getTitle());
        exist.setAssignee(updatedTask.getAssignee());
        exist.setStatus(updatedTask.getStatus());
        exist.setUpdatedDate(LocalDateTime.now());

        return taskRepository.save(exist);
    }

    public void deleteTask (Long id){
        taskRepository.deleteById(id);
    }

}
