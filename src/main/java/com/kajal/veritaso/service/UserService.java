package com.kajal.veritaso.service;

import com.kajal.veritaso.dto.RegisterRequest;
import com.kajal.veritaso.dto.RegisterResponse;
import com.kajal.veritaso.entity.User;
import com.kajal.veritaso.repository.UserRepository;
import org.springframework.stereotype.Service;
import com.kajal.veritaso.dto.LoginRequest;
import com.kajal.veritaso.dto.LoginResponse;
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public RegisterResponse registerUser(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return new RegisterResponse("Email already registered");
        }
        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userRepository.save(user);

        return new RegisterResponse("User registered successfully");
    }
    public LoginResponse loginUser(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            return new LoginResponse(
                    "Invalid email or password",
                    null
            );
        }

        if (!user.getPassword().equals(request.getPassword())) {
            return new LoginResponse(
                    "Invalid email or password",
                    null
            );
        }

        return new LoginResponse(
                "Login successful",
                user.getUsername()
        );
    }
}