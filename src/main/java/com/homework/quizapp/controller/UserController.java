package com.homework.quizapp.controller;


import com.homework.quizapp.controller.rest.requestDTO.UserLogin;
import com.homework.quizapp.controller.rest.requestDTO.UserRegister;
import com.homework.quizapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody UserRegister registerRequest) {
        final String response = userService.registerUser(registerRequest.toModel());
        return "Kayıt Başarılı..." + response;
    }

    @GetMapping("/getString")
    public String getString(){
        return "hello";
    }


}
