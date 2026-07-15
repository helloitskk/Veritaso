package com.kajal.veritaso.controller;

import com.kajal.veritaso.dto.QuestionResponse;
import com.kajal.veritaso.dto.TaskResponse;
import com.kajal.veritaso.service.QuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{quizId}")
    public List<QuestionResponse> getQuizQuestions(@PathVariable Long quizId) {
    return quizService.getQuizQuestions(quizId);
    }
}