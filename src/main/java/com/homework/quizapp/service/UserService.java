package com.homework.quizapp.service;


import com.homework.quizapp.entity.UserEntity;
import com.homework.quizapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public String registerUser(UserEntity user) {

        userRepository.save(user);
        return user.getFirstname();
    }


    /*
    public String login(UserLogin userLogin) {
        User user = userRepository.findByUserName(userLogin.getUserName());
        return user.getEmail();
    }

     */
}