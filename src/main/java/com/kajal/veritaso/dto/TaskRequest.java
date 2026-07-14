package com.kajal.veritaso.dto;

public class TaskRequest {

    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEstimatedMinutes(Integer estimatedMinutes) {
        this.estimatedMinutes = estimatedMinutes;
    }

    public void setGoalId(Long goalId) {
        this.goalId = goalId;
    }

    public String getTitle() {
        return title;
    }

    public Integer getEstimatedMinutes() {
        return estimatedMinutes;
    }

    public Long getGoalId() {
        return goalId;
    }

    private Integer estimatedMinutes;
    private Long goalId;
}