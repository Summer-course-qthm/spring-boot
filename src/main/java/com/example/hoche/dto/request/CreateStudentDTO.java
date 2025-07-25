package com.example.hoche.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStudentDTO {
    private String name;
    private int age;
}
