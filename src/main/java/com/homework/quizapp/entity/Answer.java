package com.homework.quizapp.entity;

import javax.persistence.*;
import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@Entity
@Data
@Table(name="answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @Lob
    private String text;

    //bi-directional many-to-one association to Question
    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;
}
