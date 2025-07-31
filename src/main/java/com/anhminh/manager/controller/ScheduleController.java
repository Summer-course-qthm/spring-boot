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

    @Autowired
    private SchedulesService schedulesService;

    //GET: Tất cả lịch học
    @GetMapping
    public List<ScheduleEntity> getAllSchedules() {
        return schedulesService.getAllSchedules();
    }


    //POST: Thêm lịch học
    @PostMapping
    public ResponseEntity<ScheduleEntity> createSchedule(@RequestBody ScheduleEntity scheduleEntity) {
        return ResponseEntity.ok(schedulesService.createSchedule(scheduleEntity));
    }


    //DELETE: Xóa lịch học
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Integer id) {
        schedulesService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
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
