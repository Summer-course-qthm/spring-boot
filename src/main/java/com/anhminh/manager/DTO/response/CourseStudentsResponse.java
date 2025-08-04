package com.anhminh.manager.DTO.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudentsResponse {
    private Integer courseId;
    private String courseName;
    private String courseDescription;
    private List<StudentDetailResponse> registeredStudents;
}
