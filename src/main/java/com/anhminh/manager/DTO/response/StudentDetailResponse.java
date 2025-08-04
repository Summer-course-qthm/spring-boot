package com.anhminh.manager.DTO.response;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data //Getter, Setter, String
@Builder
public class StudentDetailResponse {
    private Integer studentId;
    private String studentName;
    private String studentEmail;
    private LocalDateTime registeredAt;
}