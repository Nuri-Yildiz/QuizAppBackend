package com.homework.quizapp.controller;

import com.homework.quizapp.controller.rest.requestDTO.QuizDTO;
import com.homework.quizapp.entity.Quiz;
import com.homework.quizapp.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizService quizService;

    @GetMapping("/")
    public List<Quiz> getQuiz(){
        return quizService.getQuizList();
    }

    @PostMapping("/addQuiz")
    public String addQuiz(@RequestBody QuizDTO quizRequest){
        final String response = quizService.addQuiz(quizRequest.toModel());
        return "quiz eklendi... " + response;
    }
    @DeleteMapping("/")
    public String deleteQuiz(@RequestParam(value = "quizId")Long quizId){
        String response = quizService.deleteQuiz(quizId);
        return response;
    }
}
