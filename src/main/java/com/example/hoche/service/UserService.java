package com.example.hoche.service;

import com.example.hoche.dto.request.LoginRequest;
import com.example.hoche.dto.request.RegisterRequest;
import com.example.hoche.entity.UserEntity;
import com.example.hoche.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    public String register(RegisterRequest request) {
        // kiểm tra user tồn tại chưa
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        //tạo user mới
        UserEntity user = new UserEntity();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword())); //mã hóa password
        user.setRole("USER");

        //lưu
        userRepository.save(user);
        return "Register successful";
    }

    public String login(LoginRequest request) {

        // kiểm tra user có tồn tại hay kh
        UserEntity user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        // pass của 'user' -> ở trong db đã được encode(password: àashfdjgjksaf)
        // cầm password 'thiệt' mà user input, dùng hàm so với cái đã encode trong db
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        //tạo token và return
        return jwtService.generateToken(user.getUsername());
    }
}
