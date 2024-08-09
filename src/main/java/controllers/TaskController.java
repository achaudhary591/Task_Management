package controllers;

import models.Task;
import org.springframework.web.bind.annotation.*;
import sevices.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    private TaskService taskService;

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @GetMapping("/tasks")
    public List<Task> getTaskByUserId(@RequestParam Long userId){
        return taskService.getTasksByUserId(userId);
    }

    @PutMapping("/tasks/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task taskDetails){
        return taskService.updateTask(taskId, taskDetails);
    }

    @DeleteMapping("/tasks/{taskId}")
    public void deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
    }
}
