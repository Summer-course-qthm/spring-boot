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

    public StudentsEntity updateStudent(Long id , StudentsEntity student) {
        StudentsEntity existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        existingStudent.setStudentName(student.getStudentName());
        existingStudent.setStudentEmail(student.getStudentEmail());
        return studentRepository.save(existingStudent);
    }


    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
