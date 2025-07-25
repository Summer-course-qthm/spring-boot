package com.example.hoche.service;

import com.example.hoche.entity.StudentEntity;
import com.example.hoche.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void createStudent(String name, int age) {
        // Tạo student entity với builder
        StudentEntity newStudent = StudentEntity.builder()
                .name(name)
                .age(age)
                .build();

        // Lưu vào database
        studentRepository.save(newStudent);
    }

    public List<StudentEntity> getAgeInRange(int min, int max) {
        return studentRepository.findStudentsByAgeBetween(min, max);
    }
}
