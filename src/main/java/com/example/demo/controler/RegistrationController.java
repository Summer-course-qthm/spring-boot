package com.example.demo.controler;

import com.example.demo.DTO.Request.RegistrationsRequest;
import com.example.demo.DTO.Response.RegistrationResponse;
import com.example.demo.DTO.Response.ScheduleResponse;
import com.example.demo.DTO.Response.StudentScheduleListResponse;
import com.example.demo.entity.RegistrationsEntity;
import com.example.demo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegistrationController {
    @Autowired
    RegistrationService registrationService;
    // thêm thông tin đang ký học phần cho sinh viên
    @PostMapping("/registrations")
    public RegistrationsEntity addRegistration(@RequestBody RegistrationsRequest registrationsRequest) {
         return registrationService.addRegistration(registrationsRequest);
    }

    // lấy ra khoá học và học sinh đã đăng ký
    @GetMapping("/registrations/courses/{id}/students")
    public RegistrationResponse getStudentByCourseId(@PathVariable Long id) {
        return registrationService.getStudentByCourseId(id);
    }

    //lấy lịch tất cả lịch học của 1 sinh viên
    @GetMapping("/registrations/students/{id}/schedules")
    public StudentScheduleListResponse getScheduleByStudentId(@PathVariable Long id) {
        return registrationService.getScheduleByStudentId(id);
    }

}
