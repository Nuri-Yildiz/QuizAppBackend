package com.homework.quizapp.controller.rest.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuizDTO {
    private String name;
    private String imageUrl;

    public QuizDTO toModel() {
        return QuizDTO.builder()
                .name(name)
                .imageUrl(imageUrl)
                .build();
    }
}
