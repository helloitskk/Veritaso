package com.kajal.veritaso.controller;

import com.kajal.veritaso.dto.GoalRequest;
import com.kajal.veritaso.dto.GoalResponse;
import com.kajal.veritaso.service.GoalService;
import org.springframework.web.bind.annotation.*;
import com.kajal.veritaso.entity.Goal;
import java.util.List;
@RestController
@RequestMapping("/api/goals")
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping
    public GoalResponse createGoal(@RequestBody GoalRequest request) {

        return goalService.createGoal(request);
    }
    @GetMapping
    public List<Goal> getAllGoals() {

        return goalService.getAllGoals();
    }
}