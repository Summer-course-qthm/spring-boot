package com.example.demo.controler;

import com.example.demo.DTO.Request.ScheduleRequest;
import com.example.demo.entity.ScheduleSEntity;
import com.example.demo.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    // lấy tất cả lịch học
    @GetMapping("/schedule")
    public List<ScheduleSEntity> getSchedules() {
        return scheduleService.getAllSchedules(); // Gọi service để lấy danh sách lịch học
    }
    // thêm lịch học mới
    @PostMapping("/schedule")
    public ScheduleSEntity addSchedule(@RequestBody ScheduleRequest schedule) {
        return scheduleService.addSchedule(schedule);
    }
}
