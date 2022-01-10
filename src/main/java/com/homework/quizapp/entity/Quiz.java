package com.homework.quizapp.entity;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.homework.quizapp.controller.rest.requestDTO.QuizDTO;
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
    private Long id;

    @Column(name="image_url")
    private String imageUrl;

    private String name;

}
