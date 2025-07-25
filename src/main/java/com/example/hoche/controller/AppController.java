package com.example.hoche.controller;

import com.example.hoche.dto.request.CreateStudentDTO;
import com.example.hoche.dto.response.StudentInRangeAgeDTO;
import com.example.hoche.entity.StudentEntity;
import com.example.hoche.service.StudentService;
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
    private StudentService studentService;

    @GetMapping("/") // hoặc dùng @RequestMapping(value = "/", method = RequestMethod.GET)
    public String check() {
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

    @GetMapping("/by-age") // hoặc dùng @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<StudentInRangeAgeDTO>> createStudent(@RequestParam int min, @RequestParam int max) {//mapping
        List<StudentEntity> raw = studentService.getAgeInRange(min, max);
        List<StudentInRangeAgeDTO> processed = raw.stream()
                .map(student -> StudentInRangeAgeDTO.builder()
                        .name(student.getName())
                        .age(student.getAge())
                        .build()
                )
                .toList();

        return ResponseEntity.ok(processed);  //status code -> restful
    }

}
