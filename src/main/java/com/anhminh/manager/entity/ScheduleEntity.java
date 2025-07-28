package com.anhminh.manager.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Entity
@Table(name = "schedules")
@Getter
@Setter
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Quan hệ Many-to-One: Nhiều lịch học thuộc một khoá học
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    @JsonBackReference // Ngăn vòng lặp vô hạn khi serialize JSON
    private CourseEntity course;

    @Column(name = "day_of_week")
    private int day_of_week;

    @Column(name = "start_time")
    private Time start_time;

    @Column(name = "end_time")
    private Time end_time;

    // Getter bổ sung để hiển thị course_id trong JSON
    public Integer getCourseId() {
        return course != null ? course.getId() : null;
    }
}
