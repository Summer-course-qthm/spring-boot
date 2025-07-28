package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student_course")
@NoArgsConstructor
@AllArgsConstructor
public class StudentCourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity studentId;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private CourseEntity courseId;

}
