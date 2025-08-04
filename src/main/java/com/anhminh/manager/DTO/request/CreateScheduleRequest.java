package com.anhminh.manager.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateScheduleRequest {
    private int courseId;
    private int dayOfWeek;
    private Time startTime;
    private Time endTime;

}
