package com.anhminh.manager.controller;

import com.anhminh.manager.DTO.response.ScheduleResponse;
import com.anhminh.manager.entity.ScheduleEntity;
import com.anhminh.manager.service.SchedulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/schedule")
@RestController
public class ScheduleController {
// /schedule/course/1
//slug != query string
    @Autowired
    private SchedulesService schedulesService;

    @GetMapping
    public List<ScheduleEntity> getAllSchedules() {
        return schedulesService.getAllSchedules();
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<ScheduleResponse> getScheduleByCourse(@PathVariable Integer courseId) {
        return ResponseEntity.ok(schedulesService.getScheduleByCourse(courseId));
    }

    @GetMapping("/{id}")
    public List<ScheduleEntity> getScheduleByStudent(@PathVariable Integer studentId) {
        return schedulesService.getAllSchedules();
    }

}
