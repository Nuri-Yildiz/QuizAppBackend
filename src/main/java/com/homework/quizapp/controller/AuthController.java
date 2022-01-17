package com.homework.quizapp.controller;


import com.homework.quizapp.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    @GetMapping("/token/refresh")
    public ResponseEntity<?> refreshToken(HttpServletRequest request, HttpServletResponse response) {

        Map<String, String> refreshToken = authService.refreshToken(request, response);

        if (refreshToken.size() > 1) {
            return ResponseEntity.ok(refreshToken);
        } else {
            return ResponseEntity.ok("refresh token is not valid");
        }

    }
}
