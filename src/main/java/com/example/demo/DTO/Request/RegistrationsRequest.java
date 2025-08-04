package com.example.demo.DTO.Request;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationsRequest {
    private Long StudentId;
    private Long CourseId;
    private Timestamp createdAt;

}
