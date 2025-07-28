package com.example.demo.DTO.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UpdateRegisDTO {
    Long courseId;
    Long studentId;
    boolean isRegister;
}
