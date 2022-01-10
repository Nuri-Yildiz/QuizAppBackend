package com.homework.quizapp.service;


import com.homework.quizapp.controller.rest.requestDTO.UserLogin;
import com.homework.quizapp.controller.rest.requestDTO.UserRegister;
import com.homework.quizapp.entity.User;
import com.homework.quizapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String registerUser(UserRegister user) {

        User userEntity = new User();
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstname(user.getFirstName());
        userEntity.setLastname(user.getLastName());
        userEntity.setPassword((user.getPassword()));

        userRepository.save(userEntity);
        return userEntity.getFirstname();
    }


    public String login(UserLogin userLogin) {
        User user = userRepository.findByEmail(userLogin.getEmail()).get();
        return user.getEmail();
    }


}