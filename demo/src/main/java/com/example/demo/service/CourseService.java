package com.example.demo.service;

import com.example.demo.DTO.request.UpdateRegisDTO;
import com.example.demo.entity.CourseEntity;
import com.example.demo.entity.RegistrationEntity;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.RegistrationRepository;
import com.example.demo.repository.StudentCourseRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RegistrationRepository registrationRepository;


    public void deleteCourse(Long courseId){
        long hasStudent = registrationRepository.countByCourseId(courseId);
        if(hasStudent > 0) {
            registrationRepository.deleteByCourseId(courseId);
        }
        courseRepository.deleteById(courseId);
    }
}
