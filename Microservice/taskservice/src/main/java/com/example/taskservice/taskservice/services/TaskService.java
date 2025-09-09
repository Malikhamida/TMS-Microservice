package com.example.taskmanagement.service;

import com.example.taskmanagement.model.Task;
import com.example.taskmanagement.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void createTask(Task task) {
        taskRepository.save(task);
    }

    public List<Task> listAllTasks() {
        return taskRepository.findAll();
    }

    public void updateTask(Long taskId, Task task) {
        Task existingTask = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        existingTask.setStatus(task.getStatus());
        taskRepository.save(existingTask);
    }
}
