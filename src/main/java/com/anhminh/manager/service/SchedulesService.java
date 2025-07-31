package com.anhminh.manager.service;

import com.anhminh.manager.DTO.response.ScheduleResponse;
import com.anhminh.manager.entity.CourseEntity;
import com.anhminh.manager.entity.ScheduleEntity;
import com.anhminh.manager.repository.CoursesRepository;
import com.anhminh.manager.repository.SchedulesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchedulesService {
    @Autowired
    private SchedulesRepository schedulesRepository;

    @Autowired
    private CoursesRepository coursesRepository;

    final String[] DAYS = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    //get all lich hoc
    public List<ScheduleEntity> getAllSchedules() {
        return schedulesRepository.findAll();
    }

    //POST: Thêm lịch học
    public ScheduleEntity createSchedule(ScheduleEntity scheduleEntity) {
        return schedulesRepository.save(scheduleEntity);
    }

    //PUT: Cập nhật lịch học


    //DELETE: Xóa lịch học
    public void deleteSchedule(Integer id) {
        // Kiểm tra sự tồn tại trước khi xóa để có thông báo lỗi tốt hơn
        if (!schedulesRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy lịch học với ID: " + id);
        }
        schedulesRepository.deleteById(id);
    }



    public ScheduleResponse getScheduleByCourse(Integer courseId) {
        //lay duoc course thong qua courseId
        CourseEntity course = coursesRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + courseId));
        //select all 'course' da tim thay, trong schedule
        List<ScheduleEntity> schedules = schedulesRepository.findAllByCourse(course);
        //return
        return ScheduleResponse.builder()
                .courseId(course.getId())
                .courseName(course.getName())
                .courseDescription(course.getDescription())
                .schedule(schedules.stream().map(s -> {
                    return ScheduleResponse.ScheduleDetail.builder()
                            .date(DAYS[s.getDay_of_week()])
                            .startTime(s.getStart_time())
                            .endTime(s.getEnd_time())
                            .build();
                    }).toList())
                .build();
    }
//    public List<ScheduleEntity>


}
