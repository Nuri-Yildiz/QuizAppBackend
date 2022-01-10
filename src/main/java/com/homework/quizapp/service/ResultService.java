package com.homework.quizapp.service;

import com.homework.quizapp.controller.rest.requestDTO.ResultDTO;
import com.homework.quizapp.entity.Quiz;
import com.homework.quizapp.entity.Result;
import com.homework.quizapp.entity.User;
import com.homework.quizapp.repository.QuizRepository;
import com.homework.quizapp.repository.ResultRepository;
import com.homework.quizapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final QuizRepository quizRepository;
    private final UserRepository userRepository;
    private final ResultRepository resultRepository;
    public String saveResult(ResultDTO resultDTO) {
        Quiz quiz = quizRepository.findById(resultDTO.getQuizId()).get();
        User user = userRepository.findById(resultDTO.getUserId()).get();

        Result newResult = new Result();
        newResult.setQuiz(quiz);
        newResult.setUser(user);
        newResult.setCorrectAnswers(resultDTO.getCorrectAnswers());
        newResult.setIncorrectAnswers(resultDTO.getIncorrectAnswers());
        resultRepository.save(newResult);

        return "Cevaplarınız kaydedildi.";
    }
    public List<Result> getResults(Long userId){
        User user = userRepository.findById(userId).get();
        return resultRepository.findResultsByUser(user);

    }
}
