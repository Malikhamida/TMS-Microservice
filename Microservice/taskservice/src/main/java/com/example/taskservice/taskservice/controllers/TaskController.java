package com.example.taskmanagement.controller;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<String> createTask(@RequestBody Task task) {
        taskService.createTask(task);
        return ResponseEntity.ok("Task created successfully.");
    }

    @GetMapping("/list")
    public List<Task> listTasks() {
        return taskService.listAllTasks();
    }

    @PutMapping("/update/{taskId}")
    public ResponseEntity<String> updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        taskService.updateTask(taskId, task);
        return ResponseEntity.ok("Task updated successfully.");
    }
}
