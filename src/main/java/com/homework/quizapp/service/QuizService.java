package com.homework.quizapp.service;

import com.homework.quizapp.controller.rest.requestDTO.QuizDTO;
import com.homework.quizapp.entity.Quiz;
import com.homework.quizapp.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final QuizRepository quizRepository;

    public List<Quiz> addQuiz(QuizDTO quiz){
        Quiz quizEntity = new Quiz();
        quizEntity.setName(quiz.getName());
        quizEntity.setImageUrl(quiz.getImageUrl());
        quizRepository.save(quizEntity);
        return quizRepository.findAll();
    }


    public List<Quiz> getQuizList(){
      return quizRepository.findAll();
    }

    public List<Quiz> deleteQuiz(Long quizId) {
        quizRepository.delete(quizRepository.findById(quizId).get());
        return quizRepository.findAll();
    }

}
