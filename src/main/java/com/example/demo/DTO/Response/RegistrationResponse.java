package com.example.demo.DTO.Response;

import com.example.demo.entity.StudentsEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationResponse {
    private Long courseId;
    private String courseName;
    private String courseDescription;

    List<StudentResponse> students; // danh sách sinh viên đã đăng ký khóa học


}
