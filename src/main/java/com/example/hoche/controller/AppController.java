package com.example.hoche.controller;

import com.example.hoche.dto.request.CreateStudentDTO;
import com.example.hoche.dto.request.LoginRequest;
import com.example.hoche.dto.request.RegisterRequest;
import com.example.hoche.dto.response.StudentInRangeAgeDTO;
import com.example.hoche.entity.StudentEntity;
import com.example.hoche.service.StudentService;
import com.example.hoche.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.hoche.service.AppService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AppController {

    @Autowired
    private AppService appService;

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @GetMapping // hoặc dùng @RequestMapping(value = "/", method = RequestMethod.GET)
    public String check() {
        studentService.getUser();
        return "Hello from Spring Boot!";
    }

    @PostMapping("/create") // hoặc dùng @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> createStudent(@RequestParam String name, @RequestParam int age) { //mapping
        studentService.createStudent(name, age);
        return ResponseEntity.ok("Create successfully");  //status code -> restful
    }

    @PostMapping("/create-form") // hoặc dùng @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> createStudent(@RequestBody CreateStudentDTO data) { //mapping
        studentService.createStudent(data.getName(), data.getAge());
        return ResponseEntity.ok("Create successfully by form");  //status code -> restful
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        String message = userService.register(request);
        return ResponseEntity.ok(message);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        String token = userService.login(request);
        return ResponseEntity.ok(token);
    }

}
