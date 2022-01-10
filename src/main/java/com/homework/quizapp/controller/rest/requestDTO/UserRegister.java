package com.homework.quizapp.controller.rest.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegister {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserRegister toModel() {
        return UserRegister.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .password(password)
                .build();
    }

}
