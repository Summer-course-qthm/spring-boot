package com.anhminh.manager.controller;


import com.anhminh.manager.DTO.response.ScheduleStudentResponse;
import com.anhminh.manager.entity.RegistrationEntity;
import com.anhminh.manager.entity.StudentEntity;
import com.anhminh.manager.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student")
@RestController
public class StudentController {
    @Autowired
    private StudentsService studentsService;

    @GetMapping
    public List<StudentEntity> getAllStudents() {
        return studentsService.getAllStudents();
    }

    // POST: tạo sinh viên mới
    @PostMapping("/create")
    public StudentEntity createStudent(@RequestBody StudentEntity student) {
        return studentsService.createStudent(student);
    }

    // PUT: cập nhật thông tin sinh viên
    @PutMapping("/{id}")
    public StudentEntity updateStudent(@PathVariable int id, @RequestBody StudentEntity studentDetails) {
        return studentsService.updateStudent(id, studentDetails);
    }

    // DELETE: xoá sinh viên
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentsService.deleteStudent(id);
    }

    @GetMapping("/test/{id}")
    public ScheduleStudentResponse getCourseByStudent(@PathVariable Integer id){
        return studentsService.getCourseByStudent(id);
    }
}
