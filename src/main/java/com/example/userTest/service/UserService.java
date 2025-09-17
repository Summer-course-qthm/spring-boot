package com.example.userTest.service;

import com.example.userTest.DTO.request.LoginRequest;
import com.example.userTest.DTO.request.RegisterRequest;
import com.example.userTest.DTO.request.UserDetailProjection;
import com.example.userTest.DTO.response.UserResponse;
import com.example.userTest.entity.UserEntity;
import com.example.userTest.repository.UserRepository;
import com.example.userTest.untils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtService;

    public String register(RegisterRequest request) {
        // kiểm tra user tồn tại chưa
        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        //tạo user mới
        UserEntity user = new UserEntity();
        user.setName(request.getName());
        user.setAge(request.getAge());
        user.setAddress(request.getAddress());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole()); // "USER" hoặc "ADMIN"


        //lưu
        userRepository.save(user);
        return "Register successful";
    }

    public String login(LoginRequest request) {

        // kiểm tra user có tồn tại hay kh
        UserEntity user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));

        // pass của 'user' -> ở trong db đã được encode(password: chuỗi mã hóa)
        // cầm password 'thiệt' mà user input, dùng hàm so với cái đã encode trong db
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid username or password");
        }

        //tạo token và return
        return jwtService.generateToken(user.getUsername());
    }

    //get detail thong tin của user để xu li authen
    public UserDetailProjection getAuthenticatedUser(String username) {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not exist"));

        return UserDetailProjection.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole())
                .build();
    }
    public List<UserResponse> getAllUserResponses() {
        return userRepository.findAll().stream()
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .role(user.getRole())
                        .build())
                .toList();
    }


}
