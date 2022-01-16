package com.homework.quizapp.controller;

import com.homework.quizapp.entity.Answer;
import com.homework.quizapp.entity.Question;
import com.homework.quizapp.service.AnswerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/answers")
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping("/")
    public void addQuestion(@RequestBody List<Answer> answerList) {
        String response = answerService.addAnswers(answerList);
    }
}
