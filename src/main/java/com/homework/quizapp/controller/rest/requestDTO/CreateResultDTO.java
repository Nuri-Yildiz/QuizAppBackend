package com.homework.quizapp.controller.rest.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateResultDTO {

    private Long userId;

    private Long quizId;

    private int correctAnswers;

    private int incorrectAnswers;

}
