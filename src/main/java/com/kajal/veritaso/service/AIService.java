package com.kajal.veritaso.service;
import com.kajal.veritaso.dto.GeneratedQuestion;
import com.kajal.veritaso.entity.Task;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AIService {
    public List<GeneratedQuestion> generateQuestions(Task task) {
        List<GeneratedQuestion> questions = new ArrayList<>();
        GeneratedQuestion question1 = new GeneratedQuestion();
        question1.setQuestion("What is Spring Boot?");
        question1.setOptionA("Framework");
        question1.setOptionB("Database");
        question1.setOptionC("Compiler");
        question1.setOptionD("IDE");
        question1.setCorrectAnswer("A");
        questions.add(question1);
        GeneratedQuestion question2 = new GeneratedQuestion();
        question2.setQuestion("What does AOP stands for?");
        question2.setOptionA("Any Object Programming");
        question2.setOptionB("Aspect Oriented Programming");
        question2.setOptionC("Asset Oriented Programming");
        question2.setOptionD("Asset Oriented Protocol");
        question2.setCorrectAnswer("B");
        questions.add(question2);
        GeneratedQuestion question3 = new GeneratedQuestion();
        question3.setQuestion("What is singleton scope?");
        question3.setOptionA("This scopes the bean definition to a single instance per Spring IoC container.");
        question3.setOptionB("This scopes the bean definition to a single instance per HTTP Request.");
        question3.setOptionC("This scopes the bean definition to a single instance per HTTP Session");
        question3.setOptionD("This scopes the bean definition to a single instance per HTTP Application/ Global session");
        question3.setCorrectAnswer("A");
        questions.add(question3);

        return questions;
    }
}
