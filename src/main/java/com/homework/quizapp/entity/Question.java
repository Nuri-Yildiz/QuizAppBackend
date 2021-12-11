package com.homework.quizapp.entity;


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
    private int id;

    private byte approved;

    @Column(name="image_url")
    private String imageUrl;

    @Lob
    private String text;

    //bi-directional many-to-one association to Answer
    @OneToMany(mappedBy="question")
    @Cascade(value = {org.hibernate.annotations.CascadeType.ALL})
    private List<Answer> answers;

    //bi-directional many-to-one association to Quize
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="quiz_id")
    private Quiz quiz;
}
