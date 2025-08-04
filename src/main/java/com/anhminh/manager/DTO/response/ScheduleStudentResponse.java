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
    private LocalDateTime registeredAt;
    private List<ScheduleResponse> schedules;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ScheduleDetail {
        private String date;        // E.g. "Monday"
        private Time startTime;   // E.g. "08:00:00"
        private Time endTime; // E.g. "10:00:00"
        private Integer courseId;
    }
}
