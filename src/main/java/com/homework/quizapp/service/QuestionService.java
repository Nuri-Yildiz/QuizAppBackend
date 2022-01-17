package com.homework.quizapp.service;

import com.homework.quizapp.controller.rest.requestDTO.AnswerDTO;
import com.homework.quizapp.controller.rest.requestDTO.QuestionDTO;
import com.homework.quizapp.entity.Answer;
import com.homework.quizapp.entity.Question;
import com.homework.quizapp.entity.Quiz;
import com.homework.quizapp.repository.AnswerRepository;
import com.homework.quizapp.repository.QuestionRepository;
import com.homework.quizapp.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final QuizRepository quizRepository;
    private final AnswerRepository answerRepository;
    public Question addQuestion(Question question) {
        Question newQuestion = new Question();
        newQuestion.setText(question.getText());
        newQuestion.setImageUrl(question.getImageUrl());
        Quiz quiz = quizRepository.findById(question.getQuiz().getId()).get();
        newQuestion.setQuiz(quiz);


        return questionRepository.save(newQuestion);


    }

    public List<QuestionDTO> deleteQuestion(Long questionId) {
        var question = questionRepository.findById(questionId);
        var answers = answerRepository.findByQuestionId(questionId);
        answerRepository.deleteAll(answers);
        var quizId = question.get().getQuiz().getId();
        questionRepository.delete(questionRepository.findById(questionId).get());

        var questionDTOList = getAllQuestion2(quizId);
        return questionDTOList;
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
    public List<QuestionDTO> getAllQuestion2(Long quizId) {
        var questions = questionRepository.findQuestionsByQuiz(quizRepository.findById(quizId).get());
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question:questions) {
            var answerList = answerRepository.findByQuestionId(question.getId());
            var questionDTO = new QuestionDTO();
            questionDTO.setId(question.getId());
            questionDTO.setAnswers(toAnswerDTO(answerList));
            questionDTO.setImageUrl(question.getImageUrl());
            questionDTO.setText((question.getText()));
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
    private List<AnswerDTO> toAnswerDTO(List<Answer> answers){
        List<AnswerDTO> answerDTOList = new ArrayList<>();
        for (Answer answer:answers) {
            var answerDTO = new AnswerDTO();
            answerDTO.setId(answer.getId());
            answerDTO.setText(answer.getText());
            answerDTO.setCorrect(answer.isCorrect());
            answerDTOList.add(answerDTO);
            
        }
        return answerDTOList;
    }
}
