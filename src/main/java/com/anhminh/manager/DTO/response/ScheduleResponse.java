package com.anhminh.manager.DTO.response;

import lombok.*;

import java.sql.Time;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponse {
    private Integer courseId;
    private String courseName;
    private String courseDescription;
    private List<ScheduleDetail> schedule;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ScheduleDetail {
        private String date;        // E.g. "Monday"
        private Time startTime;   // E.g. "08:00:00"
        private Time endTime;     // E.g. "10:00:00"
    }
}