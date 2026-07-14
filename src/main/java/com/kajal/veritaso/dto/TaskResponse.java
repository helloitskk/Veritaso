package com.kajal.veritaso.dto;

public class TaskResponse {

    private String message;

    public TaskResponse() {
    }

    public TaskResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}