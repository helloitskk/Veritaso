package com.kajal.veritaso.repository;

import com.kajal.veritaso.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByGoal_Id(Long goalId);

}