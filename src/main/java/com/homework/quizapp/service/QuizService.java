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

    public String addQuiz(QuizDTO quiz){
        Quiz quizEntity = new Quiz();
        quizEntity.setName(quiz.getName());
        quizEntity.setImageUrl(quiz.getImageUrl());

        quizRepository.save(quizEntity);
        return "quiz eklendi...";
    }


    public List<Quiz> getQuizList(){
      return quizRepository.findAll();
    }

    public String deleteQuiz(Long quizId) {
        quizRepository.delete(quizRepository.findById(quizId).get());
        return "Quiz Silindi.";

    }

    /*
    public String registerUser(UserRegister user) {

        User userEntity = new User();
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstname(user.getFirstName());
        userEntity.setLastname(user.getLastName());
        userEntity.setPassword((user.getPassword()));

        userRepository.save(userEntity);
        return userEntity.getFirstname();
    }
     */
}
