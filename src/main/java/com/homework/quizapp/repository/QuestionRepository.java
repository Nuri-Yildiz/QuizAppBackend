package com.homework.quizapp.repository;

import com.homework.quizapp.entity.Question;
import com.homework.quizapp.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findQuestionsByQuiz(Quiz quiz);
}
