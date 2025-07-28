package com.anhminh.manager.service;

import com.anhminh.manager.entity.CourseEntity;
import com.anhminh.manager.repository.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoursesService {
    @Autowired
    private CoursesRepository coursesRepository;

    //get all khoa hoc
    public List<CourseEntity> getAllCourses() {
        return coursesRepository.findAll();
    }
}