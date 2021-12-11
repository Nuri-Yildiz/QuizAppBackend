package com.homework.quizapp.entity;


import lombok.Data;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="quizs")
public class Quiz  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name="image_url")
    private String imageUrl;

    private String name;

    //bi-directional many-to-one association to Question
    @OneToMany(mappedBy="quiz")
    @Cascade(value = {org.hibernate.annotations.CascadeType.ALL})
    private List<Question> questions;

    //bi-directional many-to-one association to Result
    @OneToMany(mappedBy="quiz")
    private List<Result> results;


}
