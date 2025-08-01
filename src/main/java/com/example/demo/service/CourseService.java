package com.example.demo.service;

import com.example.demo.entity.CoursesEntity;
import com.example.demo.entity.StudentsEntity;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository; // Giả sử có CourseRepository để truy cập dữ liệu

    public List<CoursesEntity> getAllCourses() {
        return courseRepository.findAll(); // Lấy tất cả khóa học từ cơ sở dữ liệu
    }

    public CoursesEntity addCourse(CoursesEntity course) {
        return courseRepository.save(course);
    }

    public CoursesEntity updateCourse(Long id, CoursesEntity course) {
        CoursesEntity checkCourse = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));

        checkCourse.setCourseName(course.getCourseName());
        checkCourse.setCourseDesc(course.getCourseDesc());
        return courseRepository.save(checkCourse);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id); // Xóa khóa học theo ID
    }
}
