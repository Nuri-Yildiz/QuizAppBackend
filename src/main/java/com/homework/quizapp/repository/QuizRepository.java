package com.homework.quizapp.repository;

import com.homework.quizapp.entity.Quiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    @Override
    Optional<Quiz> findById(Long aLong);

    @Override
    Page<Quiz> findAll(Pageable pageable);
}
