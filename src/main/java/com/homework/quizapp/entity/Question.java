package com.homework.quizapp.entity;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name="questions")
public class Question  {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="image_url")
    private String imageUrl;

    @Lob
    private String text;

    //@OneToMany(mappedBy="question")
    //@Cascade(value = {org.hibernate.annotations.CascadeType.ALL})
    //private List<Answer> answers;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="quiz_id")
    private Quiz quiz;
}
