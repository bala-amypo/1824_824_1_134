package com.example.healthcare.service;

import com.example.healthcare.dto.AuthRequest;
import com.example.healthcare.dto.RegisterRequest;
import com.example.healthcare.entity.AppUser;

public interface AuthService {

    AppUser register(RegisterRequest request);

    AppUser login(AuthRequest request);
}
