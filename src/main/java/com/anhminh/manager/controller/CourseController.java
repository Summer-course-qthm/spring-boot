package com.anhminh.manager.controller;

import com.anhminh.manager.entity.CourseEntity;
import com.anhminh.manager.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/course")
@RestController
public class CourseController {
    @Autowired
    private CoursesService coursesService;

    @GetMapping
    public List<CourseEntity> getAllCourses() {
        return coursesService.getAllCourses();
    }

    // POST: tạo khoá học mới
    @PostMapping("/create")
    public  CourseEntity createCourse(CourseEntity course) {
        return coursesService.createCourse(course);
    }
    // PUT: cập nhật thông tin khoá học
    @PutMapping("{id}")
    public CourseEntity updateCourse(@PathVariable int id, @RequestBody CourseEntity courseDetails) {
        return coursesService.updateCourse(id, courseDetails);
    }

    // DELETE: Xoá khoá học
    @DeleteMapping("{id}")
    public void deleteCourse(@PathVariable int id) {
        coursesService.deleteCourse(id);
    }
}
