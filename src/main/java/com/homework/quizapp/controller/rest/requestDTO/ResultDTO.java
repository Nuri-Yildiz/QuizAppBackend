package com.homework.quizapp.controller.rest.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultDTO {
    private int correctAnswers;
    private int incorrectAnswers;
    private Long userId;
    private Long quizId;
}
