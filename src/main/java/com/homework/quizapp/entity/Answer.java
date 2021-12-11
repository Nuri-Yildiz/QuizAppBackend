package com.homework.quizapp.entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Entity
@Data
@Table(name="answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "is_correct")
    private byte isCorrect;

    @Lob
    private String text;

    //bi-directional many-to-one association to Question
    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;
}
