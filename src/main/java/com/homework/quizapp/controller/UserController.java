package com.homework.quizapp.controller;


import com.homework.quizapp.entity.UserEntity;
import com.homework.quizapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody UserEntity user) {
        return userService.registerUser(user);
    }

    @GetMapping("/getString")
    public String getString(){
        return "hello";
    }
   /*
    @PostMapping("login")
    public String login(@RequestBody UserLogin loginRequest) {
        final String response = userService.login(loginRequest.toModel());
        return "Giriş Yapıldı..." + response;
    }
    */


}
