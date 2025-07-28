package com.example.demo.controller;


import com.example.demo.DTO.request.UpdateRegisDTO;
import com.example.demo.entity.StudentEntity;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegisterationController {

    @Autowired
    private CourseService courseService;

    @DeleteMapping("/course/{courseId}")
    public ResponseEntity<String> updateRegisteration(@RequestParam Long courseId) {
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok("Updated successfully!");
    }
}