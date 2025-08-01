package com.example.demo.DTO.Request;

import lombok.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleRequest {
    private Long courseId;
    private int dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

}
