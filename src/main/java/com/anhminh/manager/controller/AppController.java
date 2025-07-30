package com.anhminh.manager.controller;

import com.anhminh.manager.entity.CourseEntity;
import com.anhminh.manager.entity.RegistrationEntity;
import com.anhminh.manager.entity.ScheduleEntity;
import com.anhminh.manager.entity.StudentEntity;
import com.anhminh.manager.service.CoursesService;
import com.anhminh.manager.service.RegistrationsService;
import com.anhminh.manager.service.SchedulesService;
import com.anhminh.manager.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    private StudentsService studentService;

    @Autowired
    private CoursesService coursesService;


    @Autowired
    private RegistrationsService registrationsService;


    @GetMapping("/")
    public String check() {
        return "Phùng Đặng Anh Minh";
    }

    //Start Student
    @GetMapping("/students")
    public List<StudentEntity> getAllStudents() {
        return studentService.getAllStudents();
    }
    // POST: tạo sinh viên mới
    @PostMapping("/students")
    public StudentEntity createStudent(@RequestBody StudentEntity student) {
        return studentService.createStudent(student);
    }

    // PUT: cập nhật thông tin sinh viên
    @PutMapping("/students/{id}")
    public StudentEntity updateStudent(@PathVariable int id, @RequestBody StudentEntity studentDetails) {
        return studentService.updateStudent(id, studentDetails);
    }

    // DELETE: xoá sinh viên
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
    }
    //End Student


    //Start Courses
    @GetMapping("/courses")
    public List<CourseEntity> getAllCourses() {
        return coursesService.getAllCourses();
    }
    // POST: Tạo khoá học
    @PostMapping("/courses")
    public CourseEntity createCourse(@RequestBody CourseEntity course) {
        return coursesService.createCourse(course);
    }

    // PUT: Cập nhật khoá học
    @PutMapping("/courses/{id}")
    public CourseEntity updateCourse(@PathVariable int id, @RequestBody CourseEntity courseDetails) {
        return coursesService.updateCourse(id, courseDetails);
    }

    // DELETE: Xoá khoá học
    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable int id) {
        coursesService.deleteCourse(id);
    }
    //End Courses




}