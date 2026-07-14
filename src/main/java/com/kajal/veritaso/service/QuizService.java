package com.kajal.veritaso.service;
import com.kajal.veritaso.dto.TaskResponse;
import com.kajal.veritaso.entity.Quiz;
import com.kajal.veritaso.entity.Task;
import org.springframework.stereotype.Service;
import com.kajal.veritaso.repository.QuizRepository;
import com.kajal.veritaso.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final TaskRepository taskRepository;
    private final AIService aiService;

    public QuizService(TaskRepository taskRepository,
                       QuizRepository quizRepository, AIService aiService) {

        this.taskRepository = taskRepository;
        this.quizRepository = quizRepository;
        this.aiService = aiService;
    }
    public TaskResponse createQuiz(Long taskId){

        Task task = taskRepository.findById(taskId).orElse(null);

        if(task == null){
            return new TaskResponse("Task not found");
        }
        if(!task.getStatus().equals("QUIZ_REQUIRED")){
            return new TaskResponse("Task is not ready for quiz");
        }
        List<Quiz> quizzes = quizRepository.findByTask_Id(taskId);

        Integer attemptNumber = quizzes.size() + 1;

        Quiz quiz = new Quiz();

        quiz.setTask(task);
        quiz.setAttemptNumber(attemptNumber);
        quiz.setStatus("PENDING");
        quiz.setScore(null);
        quiz.setCreatedAt(LocalDateTime.now());

        quizRepository.save(quiz);

        return new TaskResponse("Quiz created successfully");
    }
}
