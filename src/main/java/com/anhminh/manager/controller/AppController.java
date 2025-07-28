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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    private StudentsService studentService;

    @Autowired
    private CoursesService coursesService;

    @Autowired
    private SchedulesService schedulesService;

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
    //End Student


    //Start Courses
    @GetMapping("/courses")
    public List<CourseEntity> getAllCourses() {
        return coursesService.getAllCourses();
    }
    //End Courses

    //Start Schedules
    @GetMapping("/schedules")
    public List<ScheduleEntity> getAllSchedules() {
        return schedulesService.getAllSchedules();
    }
    //End Schedules


    //Start Registrations
    @GetMapping("/re")
    public List<RegistrationEntity> getAllSRe() {
        return registrationsService.getAllRe();
    }
    //End Registrations
}