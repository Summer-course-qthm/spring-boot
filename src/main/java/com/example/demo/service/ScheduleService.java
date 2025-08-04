package com.example.demo.service;

import com.example.demo.DTO.Request.ScheduleRequest;
import com.example.demo.DTO.Response.ScheduleResponse;
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

    @Autowired
    private CourseRepository courseRepository; // Giả sử có CourseRepository để truy cập dữ liệu

    final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

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

    public void deleteSchedule(Long id) {
         scheduleRepository.deleteById(id);
    }


    public List<ScheduleSEntity> getAllSchedule() {
        return scheduleRepository.findAll();
    }

    public ScheduleResponse getAllCourseById(Long id) {
        CoursesEntity course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + id));

        // Lấy danh sách khóa học ừ lịch hc
        List<ScheduleSEntity> schedules = scheduleRepository.findAllByCourse(course);// lọc theo khóa hc trong bảng schedule

        ScheduleResponse response = new ScheduleResponse();
        response.setCourseId(course.getId());
        response.setCourseName(course.getCourseName());
        response.setCourseDescription(course.getCourseDesc());

        // tìm thơi gian và ngày trong lịch học
        List<ScheduleResponse.ScheduleItem> scheduleItems = schedules.stream()
                .map(schedule -> new ScheduleResponse.ScheduleItem(
                        DAYS[schedule.getDayOfWeek().intValue()],
                        schedule.getStartTime(),
                        schedule.getEndTime()
                        )
                ).toList();

        response.setSchedule(scheduleItems);
        return response;
    }
}
