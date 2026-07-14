package com.kajal.veritaso.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public Integer getEstimatedMinutes() {
        return estimatedMinutes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEstimatedMinutes(Integer estimatedMinutes) {
        this.estimatedMinutes = estimatedMinutes;
    }

    private String title;
    private String status;
    private Integer estimatedMinutes;
    @ManyToOne
    @JoinColumn(name = "goal_id", nullable = false)
    private Goal goal;

    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }

    public List<Quiz> getQuizzes() {
        return quizzes;
    }

    @OneToMany(mappedBy = "task")
    @JsonIgnore
    private List<Quiz> quizzes;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;


    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }

}
