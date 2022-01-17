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

    @GetMapping("/getQuiz")
    public List<Quiz> getQuiz(){
        return quizService.getQuizList();
    }

    @PostMapping("/addQuiz")
    public List<Quiz> addQuiz(@RequestBody QuizDTO quizRequest){
        return  quizService.addQuiz(quizRequest.toModel());
    }
    @DeleteMapping("/{quizId}")
    public List<Quiz> deleteQuiz(@PathVariable Long quizId){
        return quizService.deleteQuiz(quizId);
    }
}
