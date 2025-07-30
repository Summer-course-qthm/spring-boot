package com.example.demo.service;

import com.example.demo.entity.StudentsEntity;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public StudentsEntity addStudent(StudentsEntity student) {
        return studentRepository.save(student);
    }

    public List<StudentsEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    public StudentsEntity updateStudent(StudentsEntity student) {
        return studentRepository.save(student);
    }
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
