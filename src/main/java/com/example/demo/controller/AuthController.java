package com.example.healthcare.controller;

import com.example.healthcare.dto.AuthRequest;
import com.example.healthcare.dto.RegisterRequest;
import com.example.healthcare.entity.AppUser;
import com.example.healthcare.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AppUser register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AppUser login(@RequestBody AuthRequest request) {
        return authService.login(request);
    }
}
