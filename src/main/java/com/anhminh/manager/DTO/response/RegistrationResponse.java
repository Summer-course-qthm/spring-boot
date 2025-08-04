package com.anhminh.manager.DTO.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class RegistrationResponse {
    private int id;
    private LocalDateTime registeredAt;
    private StudentInfo student;
    private CourseInfo course;

    @Getter
    @Setter
    public static class StudentInfo {
        private int id;
        private String name;
    }

    @Getter
    @Setter
    public static class CourseInfo {
        private int id;
        private String name;
    }
}