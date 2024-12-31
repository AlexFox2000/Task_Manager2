package com.task.mc_task.controller;


import com.task.mc_task.entity.Status;
import com.task.mc_task.entity.Task;
import com.task.mc_task.service.TaskService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public Task createTask (@RequestBody Task task){
        return taskService.createdNewTask(task);
    }

    @GetMapping ({"/id"})
    public Task getTaskById (@PathVariable Long id){
        return taskService.getTaskById(id);
    }

    @GetMapping
    public List<Task> getAllTasks (){
        return taskService.getAllTasks();
    }

    @GetMapping
    public List<Task> getTasksByFilter(@RequestBody Status status){
        return taskService.getTaskByFilter(status);
    }

    @PutMapping ({"/id"})
    public Task updateTask ( @RequestBody Task task, @PathVariable Long id){
        return taskService.updatedTask(task, id);
    }

    @DeleteMapping
    public void deleteTask (@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
