package com.example.demo.DTO.Response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentScheduleListResponse {
    private Long studentId;
    private String studentName;
    List<ScheduleResponse> schedules; // danh sách lịch học của sinh viên


}
