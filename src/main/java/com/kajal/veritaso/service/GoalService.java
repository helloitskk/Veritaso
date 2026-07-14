package com.kajal.veritaso.service;

import com.kajal.veritaso.dto.GoalRequest;
import com.kajal.veritaso.dto.GoalResponse;
import com.kajal.veritaso.entity.Goal;
import com.kajal.veritaso.repository.GoalRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GoalService {

    private final GoalRepository goalRepository;

    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    public GoalResponse createGoal(GoalRequest request) {

        Goal goal = new Goal();

        goal.setTitle(request.getTitle());
        goal.setTargetDate(request.getTargetDate());

        goalRepository.save(goal);

        return new GoalResponse("Goal created successfully");
    }
    public List<Goal> getAllGoals() {

        return goalRepository.findAll();
    }
}