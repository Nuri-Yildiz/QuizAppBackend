package com.homework.quizapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="results")
public class Result  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "correct_answers")
    private int correctAnswers;

    @Column(name = "incorrect_answers")
    private int incorrectAnswers;

    //bi-directional many-to-one association to Quize
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    //bi-directional many-to-one association to User
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
}
