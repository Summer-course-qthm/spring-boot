package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;

@Entity
@Table(name = "schedules")
@Getter
@Setter
@AllArgsConstructor
@Builder
public class ScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Quan hệ Many-to-One: Nhiều lịch học cho một khóa học
    @ManyToOne(fetch = FetchType.LAZY) // Tai luoi bien
    @JoinColumn(name = "course_id", nullable = false) // lien ket voi khoa ngoai
    private CourseEntity course;

    @Column(name = "day_of_week")
    private int day_of_week;

    @Column(name = "start_time")
    private Time start_time;

    @Column(name = "end_time")
    private Time end_time;
}