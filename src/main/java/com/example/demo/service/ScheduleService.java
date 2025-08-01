package com.example.demo.service;

import com.example.demo.DTO.Request.ScheduleRequest;
import com.example.demo.entity.CoursesEntity;
import com.example.demo.entity.ScheduleSEntity;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service



public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository; // Giả sử có ScheduleRepository để truy cập dữ liệu
    public List<ScheduleSEntity> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    @Autowired
    private CourseRepository courseRepository; // Giả sử có CourseRepository để truy cập dữ liệu
    public ScheduleSEntity addSchedule(ScheduleRequest schedule) {
        // tìm khóa học
        CoursesEntity course = courseRepository.findById(schedule.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + schedule.getCourseId()));
       // System.out.println(course.getCourseName());
        // chuyển từ request sang entity lại
        ScheduleSEntity scheduleEntity = new ScheduleSEntity();
        scheduleEntity.setCourse(course);
        scheduleEntity.setDayOfWeek((long)schedule.getDayOfWeek());
        scheduleEntity.setStartTime(schedule.getStartTime());
        scheduleEntity.setEndTime(schedule.getEndTime());
        // lưu lịch học vào cơ sở dữ liệu
        return scheduleRepository.save(scheduleEntity);
    }
}
