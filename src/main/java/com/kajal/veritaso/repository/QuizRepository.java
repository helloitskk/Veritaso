package com.kajal.veritaso.repository;

import com.kajal.veritaso.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    List<Quiz> findByTask_Id(Long taskId);

}