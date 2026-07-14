package com.kajal.veritaso.controller;

import com.kajal.veritaso.dto.TaskResponse;
import com.kajal.veritaso.service.QuizService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping("/{taskId}")
    public TaskResponse createQuiz(@PathVariable Long taskId) {
        return quizService.createQuiz(taskId);
    }
}