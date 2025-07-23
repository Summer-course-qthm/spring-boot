package com.pdam.anhminh.controller;

import com.pdam.anhminh.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Autowired
    private AppService appService;

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Anh Minh");
    }

    @GetMapping("/age")
    public ResponseEntity<Integer> getAge() {
        int age = appService.getAge();
        return ResponseEntity.ok(age);
    }
}