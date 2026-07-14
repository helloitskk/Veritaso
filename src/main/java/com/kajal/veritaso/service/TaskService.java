package com.kajal.veritaso.service;

import com.kajal.veritaso.dto.TaskRequest;
import com.kajal.veritaso.dto.TaskResponse;
import com.kajal.veritaso.entity.Task;
import com.kajal.veritaso.repository.TaskRepository;
import com.kajal.veritaso.entity.Goal;
import com.kajal.veritaso.repository.GoalRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDateTime;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final GoalRepository goalRepository;
    public TaskService(TaskRepository taskRepository,
                       GoalRepository goalRepository) {
        this.taskRepository = taskRepository;
        this.goalRepository = goalRepository;
    }

    public TaskResponse createTask(TaskRequest request) {

        Task task = new Task();

        task.setTitle(request.getTitle());
        task.setEstimatedMinutes(request.getEstimatedMinutes());

        Goal goal = goalRepository.findById(request.getGoalId()).orElse(null);

        if (goal == null) {
            return new TaskResponse("Goal not found");
        }

        task.setGoal(goal);

        task.setStatus("PENDING");

        taskRepository.save(task);

        return new TaskResponse("Task created successfully");
    }
    public List<Task> getAllTasks() {

        return taskRepository.findAll();
    }
    public List<Task> getTasksByGoalId(Long goalId) {

        return taskRepository.findByGoal_Id(goalId);
    }
    public TaskResponse completeTask(Long taskId) {

        Task task = taskRepository.findById(taskId).orElse(null);

        if(task == null){
            return new TaskResponse("Task not found");
        }

        if(task.getStatus().equals("COMPLETED")){
            return new TaskResponse("Task already completed");
        }

        if(!task.getStatus().equals("QUIZ_REQUIRED")){
            return new TaskResponse("Task must pass quiz before completion");
        }

        task.setCompletedAt(LocalDateTime.now());
        task.setStatus("COMPLETED");

        taskRepository.save(task);

        return new TaskResponse("Task completed successfully");
    }
    public TaskResponse markQuizRequired(Long taskId) {

        Task task = taskRepository.findById(taskId).orElse(null);

        if (task == null) {
            return new TaskResponse("Task not found");
        }
        if(task.getStatus().equals("PENDING")){
            return new TaskResponse("Please start the task first.");
        }
        if (task.getStatus().equals("QUIZ_REQUIRED")) {
            return new TaskResponse("Task is already awaiting quiz");
        }

        if (task.getStatus().equals("COMPLETED")) {
            return new TaskResponse("Task already completed");
        }
        task.setStatus("QUIZ_REQUIRED");

        taskRepository.save(task);

        return new TaskResponse("Task moved to quiz stage");
    }

    public TaskResponse startTask(Long taskId){
        Task task = taskRepository.findById(taskId).orElse(null);
        if(task==null){
            return new TaskResponse("Task not found");
        }
        if (task.getStatus().equals("IN_PROGRESS")) {
            return new TaskResponse("Task already started");
        }
        if(task.getStatus().equals("COMPLETED")){
            return new TaskResponse("Task already completed");
        }
        if(task.getStatus().equals("QUIZ_REQUIRED")){
            return new TaskResponse("Task is awaiting quiz completion");
        }
        task.setStartedAt(LocalDateTime.now());
        task.setStatus("IN_PROGRESS");
        taskRepository.save(task);
        return new TaskResponse("Task started successfully");
    }
}