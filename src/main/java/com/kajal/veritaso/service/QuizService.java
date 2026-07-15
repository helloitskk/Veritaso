package com.kajal.veritaso.service;
import com.kajal.veritaso.dto.GeneratedQuestion;
import com.kajal.veritaso.dto.QuestionResponse;
import com.kajal.veritaso.dto.TaskResponse;
import com.kajal.veritaso.entity.Question;
import com.kajal.veritaso.entity.Quiz;
import com.kajal.veritaso.entity.Task;
import com.kajal.veritaso.repository.QuestionRepository;
import org.springframework.stereotype.Service;
import com.kajal.veritaso.repository.QuizRepository;
import com.kajal.veritaso.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final TaskRepository taskRepository;
    private final AIService aiService;
    private final QuestionRepository questionRepository;

    public QuizService(TaskRepository taskRepository,
                       QuizRepository quizRepository, AIService aiService, QuestionRepository questionRepository) {

        this.taskRepository = taskRepository;
        this.quizRepository = quizRepository;
        this.aiService = aiService;
        this.questionRepository = questionRepository;
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
        List<GeneratedQuestion> generatedQuestions = aiService.generateQuestions(task);
        for (GeneratedQuestion generatedQuestion : generatedQuestions) {
            Question question = new Question();

            question.setQuestion(generatedQuestion.getQuestion());
            question.setOptionA(generatedQuestion.getOptionA());
            question.setOptionB(generatedQuestion.getOptionB());
            question.setOptionC(generatedQuestion.getOptionC());
            question.setOptionD(generatedQuestion.getOptionD());
            question.setCorrectAnswer(generatedQuestion.getCorrectAnswer());

            question.setQuiz(quiz);
            questionRepository.save(question);

        }
        return new TaskResponse("Quiz created successfully");
    }

    public List<QuestionResponse> getQuizQuestions(Long quizId) {

        List<Question> questions = questionRepository.findByQuiz_Id(quizId);
        List<QuestionResponse> responses = new ArrayList<>();
        for (Question question : questions) {
            QuestionResponse response = new QuestionResponse();
            response.setId(question.getId());
            response.setQuestion(question.getQuestion());
            response.setOptionA(question.getOptionA());
            response.setOptionB(question.getOptionB());
            response.setOptionC(question.getOptionC());
            response.setOptionD(question.getOptionD());

            responses.add(response);
        }
        return responses;
    }
}
