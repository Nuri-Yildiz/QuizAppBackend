package com.homework.quizapp.service;

import com.homework.quizapp.entity.Answer;
import com.homework.quizapp.repository.AnswerRepository;
import com.homework.quizapp.repository.QuestionRepository;
import com.homework.quizapp.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public String addAnswers(List<Answer> answerList) {
        for (Answer answer:answerList) {
            saveAnswer(answer);
        }
        return "Cevaplar Kaydedildi.";
    }

    public Answer saveAnswer(Answer answer){
        Answer newAnswer = new Answer();
        newAnswer.setText(answer.getText());
        //newAnswer.setIsCorrect(answer.getIsCorrect());
        newAnswer.setCorrect(answer.isCorrect());
        newAnswer.setQuestion(questionRepository.findById(answer.getQuestion().getId()).get());
        return answerRepository.save(newAnswer);

    }
}
