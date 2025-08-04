package com.anhminh.manager.DTO.response;

import lombok.*;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class ScheduleStudentResponse {
    private Integer studentId;
    private String studentName;
    private String studentEmail;
    private List<ScheduleResponse> schedules;

}
