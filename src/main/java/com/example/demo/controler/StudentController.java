package com.example.demo.controler;

import com.example.demo.entity.StudentsEntity;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public List <StudentsEntity> getStudent() {
        return studentService.getAllStudents(); // Giả sử có phương thức getAllStudents trong StudentService
    }


    @PostMapping("/student")
    public StudentsEntity addStudent(@RequestBody StudentsEntity student) {
        return studentService.addStudent(student);
    }
    @PutMapping("/student/{id}")
    public StudentsEntity updateStudent(@PathVariable Long id, @RequestBody StudentsEntity student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
