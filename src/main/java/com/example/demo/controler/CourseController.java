package com.example.demo.controler;


import com.example.demo.entity.CoursesEntity;
import com.example.demo.entity.StudentsEntity;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {
    @Autowired
    private CourseService courseService; // Giả sử có CourseService để xử lý logic liên
    // lấy danh sách khóa học
    @GetMapping("/course")
    public List<CoursesEntity> getCourses() {
        // Gọi service để lấy danh sách khóa học
        return courseService.getAllCourses(); // Giả sử có phương thức getAllCourses trong CourseService
    }
    // thêm khóa học mới
    @PostMapping("/course")
    public CoursesEntity addCourses(@RequestBody CoursesEntity course) {
        // Gọi service để thêm khóa học mới
        return courseService.addCourse(course); // Giả sử có phương thức getAllCourses trong CourseService
    }
    // cập nhật thông tin khóa học
    @PutMapping("/course/{id}")
    public CoursesEntity updateCourse(@PathVariable Long id, @RequestBody CoursesEntity course){
        return courseService.updateCourse(id , course);
    }
    // xóa khóa học
    @DeleteMapping("/course/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id); // Giả sử có phương thức deleteCourse trong CourseService
    }
}
