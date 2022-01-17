package com.homework.quizapp.service;

import com.homework.quizapp.controller.rest.requestDTO.CreateResultDTO;
import com.homework.quizapp.controller.rest.requestDTO.ResultDTO;
import com.homework.quizapp.entity.Quiz;
import com.homework.quizapp.entity.Result;
import com.homework.quizapp.entity.User;
import com.homework.quizapp.repository.QuizRepository;
import com.homework.quizapp.repository.ResultRepository;
import com.homework.quizapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final QuizRepository quizRepository;
    private final UserRepository userRepository;
    private final ResultRepository resultRepository;
    public String saveResult(CreateResultDTO resultDTO) {
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
    public List<ResultDTO> getResults(){
        var results = resultRepository.findAll();
        List<ResultDTO> resultDTOList = new ArrayList<>();
        for (Result result: results) {
            ResultDTO resultDTO = new ResultDTO();
            resultDTO.setCorrectAnswerCount(result.getCorrectAnswers());
            resultDTO.setQuestionCount(result.getCorrectAnswers()+result.getIncorrectAnswers());
            resultDTO.setQuizName(result.getQuiz().getName());
            resultDTO.setUserName(result.getUser().getFirstname() + " " + result.getUser().getLastname());
            resultDTOList.add(resultDTO);
        }
        return resultDTOList;
    }
}
