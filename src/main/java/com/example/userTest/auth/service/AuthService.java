package com.example.userTest.auth.service;

import com.example.userTest.DTO.request.LoginRequest;
import com.example.userTest.DTO.request.RegisterRequest;
import com.example.userTest.entity.UserEntity;
import com.example.userTest.repository.UserRepository;
import com.example.userTest.untils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired private UserRepository userRepository;
    @Autowired private PasswordEncoder passwordEncoder;
    @Autowired private JwtUtil jwtUtil;

    public String register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        UserEntity user = UserEntity.builder()
                .name(request.getName())
                .age(request.getAge())
                .role(request.getRole()) // Có thể hardcode nếu không muốn cho user chọn
                .address(request.getAddress())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
        return "Register successful";
    }

    public String login(LoginRequest request) {
        UserEntity user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        return jwtUtil.generateToken(user.getUsername());
    }
}
