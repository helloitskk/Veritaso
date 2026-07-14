package com.kajal.veritaso.dto;

public class GoalResponse {

    private String message;

    public GoalResponse() {
    }

    public GoalResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}