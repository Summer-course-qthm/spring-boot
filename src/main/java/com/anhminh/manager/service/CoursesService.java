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
    // Thêm khoá học mới
    public CourseEntity createCourse(CourseEntity course) {
        return coursesRepository.save(course);
    }

    // Cập nhật khoá học
    public CourseEntity updateCourse(int id, CourseEntity courseDetails) {
        CourseEntity course = coursesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));

        course.setName(courseDetails.getName());
        course.setDescription(courseDetails.getDescription());

        return coursesRepository.save(course);
    }

    // Xoá khoá học
    public void deleteCourse(int id) {
        coursesRepository.deleteById(id);
    }

}