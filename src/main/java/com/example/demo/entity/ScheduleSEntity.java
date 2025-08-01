package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;

@Entity
@Table(name = "schedules")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScheduleSEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToOne()
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private CoursesEntity course;

    @Column(name = "day_of_week")
    private Long dayOfWeek;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "end_time")
    private LocalTime endTime;

}
