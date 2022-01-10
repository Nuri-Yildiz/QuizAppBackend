package com.homework.quizapp.service;

import com.homework.quizapp.entity.Question;
import com.homework.quizapp.entity.Quiz;
import com.homework.quizapp.repository.QuestionRepository;
import com.homework.quizapp.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;
    public String addQuestion(Question question) {
        Question newQuestion = new Question();
        newQuestion.setText(question.getText());
        newQuestion.setImageUrl(question.getImageUrl());
        Quiz quiz = quizRepository.findById(question.getQuiz().getId()).get();
        newQuestion.setQuiz(quiz);
        questionRepository.save(newQuestion);

        return "Soru kaydedildi...";


    }

    public String deleteQuestion(Long questionId) {
        questionRepository.delete(questionRepository.findById(questionId).get());
        return "Soru Silindi.";
    }
    public String updateQuestion(Question question){
        Question newQuestion = questionRepository.findById(question.getId()).get();
        newQuestion.setText(question.getText());
        newQuestion.setImageUrl(question.getImageUrl());
        questionRepository.save(newQuestion);

        return "Soru Güncellendi.";
    }

    public List<Question> getAllQuestion(Long quizId) {

        return questionRepository.findQuestionsByQuiz(quizRepository.findById(quizId).get());
    }
}
