package com.kajal.veritaso.repository;
import com.kajal.veritaso.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
