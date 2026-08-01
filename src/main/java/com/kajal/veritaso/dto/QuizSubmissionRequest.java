package com.kajal.veritaso.dto;

import com.kajal.veritaso.entity.Question;

import java.util.List;

public class QuizSubmissionRequest {
    private List<AnswerRequest> answers ;

    public List<AnswerRequest> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerRequest> answers) {
        this.answers = answers;
    }
}
