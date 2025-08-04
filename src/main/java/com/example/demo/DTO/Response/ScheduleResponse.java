package com.example.demo.DTO.Response;


import lombok.*;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponse {
    // dùng để trả về lịch học theo khóa học
    //{
    //    "courseId": 1,
    //    "courseName": "test thay doi",
    //    "courseDescription": null,
    //    "schedule": [
    //        {
    //            "date": "Monday",
    //            "startTime": "08:00:00",
    //            "endTime": "10:00:00",
    //            "courseId": null
    //        },
    //        {
    //            "date": "Wednesday",
    //            "startTime": "08:00:00",
    //            "endTime": "10:00:00",
    //            "courseId": null
    //        }
    //    ]
    //}

    private Long courseId;
    private String courseName;
    private String courseDescription;
    private List<ScheduleItem> schedule;


    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static  class ScheduleItem {
        private String date;
        private LocalTime startTime;
        private LocalTime endTime;

    }

}
