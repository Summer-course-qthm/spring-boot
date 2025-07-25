package com.example.hoche.controller;

import com.example.hoche.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.hoche.service.AppService;

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
    public ResponseEntity<String> createStudent( @RequestParam String name, @RequestParam int age) { //mapping
        studentService.createStudent(name, age);
        return ResponseEntity.ok("Create successfully");  //status code -> restful
    }

}
