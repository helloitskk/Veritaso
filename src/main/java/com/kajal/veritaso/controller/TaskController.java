package com.kajal.veritaso.controller;
import com.kajal.veritaso.dto.TaskRequest;
import com.kajal.veritaso.dto.TaskResponse;
import com.kajal.veritaso.service.TaskService;
import org.springframework.web.bind.annotation.*;
import com.kajal.veritaso.entity.Task;
import java.util.List;
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public TaskResponse createTask(@RequestBody TaskRequest request) {

        return taskService.createTask(request);
    }
    @GetMapping
    public List<Task> getAllTasks() {

        return taskService.getAllTasks();
    }
    @GetMapping("/goal/{goalId}")
    public List<Task> getTasksByGoalId(@PathVariable Long goalId) {

        return taskService.getTasksByGoalId(goalId);
    }
    @PutMapping("/{taskId}/complete")
    public TaskResponse completeTask(@PathVariable Long taskId) {

        return taskService.completeTask(taskId);
    }
    @PutMapping("/{taskId}/quiz-required")
    public TaskResponse markQuizRequired(@PathVariable Long taskId) {

        return taskService.markQuizRequired(taskId);
    }
    @PutMapping("/{taskId}/start")
    public TaskResponse startTask(@PathVariable Long taskId) {

        return taskService.startTask(taskId);
    }
}