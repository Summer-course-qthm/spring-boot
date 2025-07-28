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



    // Quan hệ Many-to-One: Nhiều lịch học cho một khóa học
    @ManyToOne(fetch = FetchType.LAZY) // Tai luoi bien
    @JoinColumn(name = "course_id", nullable = false) // lien ket voi khoa ngoai
    @JsonBackReference // THÊM DÒNG NÀY
    private CourseEntity course;

    @Column(name = "day_of_week")
    private int day_of_week;
    @Column(name = "start_time")
    private Time start_time;
    @Column(name = "end_time")
    private Time end_time;
}
