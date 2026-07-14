package com.kajal.veritaso.controller;

import com.kajal.veritaso.dto.RegisterRequest;
import com.kajal.veritaso.dto.RegisterResponse;
import com.kajal.veritaso.service.UserService;
import org.springframework.web.bind.annotation.*;
import com.kajal.veritaso.dto.LoginRequest;
import com.kajal.veritaso.dto.LoginResponse;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public RegisterResponse registerUser(@RequestBody RegisterRequest request) {

        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public LoginResponse loginUser(@RequestBody LoginRequest request) {

        return userService.loginUser(request);
    }
}