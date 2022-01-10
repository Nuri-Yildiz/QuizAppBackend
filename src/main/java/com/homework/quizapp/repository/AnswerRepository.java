package com.homework.quizapp.repository;

import com.homework.quizapp.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    public Optional<Answer> findById(Long id);

    List<Answer> findByQuestionId(Long id);
}
