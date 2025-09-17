package com.example.userTest.DTO.response;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data //Getter, Setter, String
@Builder
public class UserResponse {
    private Long id;
    private String name;
    private Integer age;
    private String address;
    private String username;
    private String role;
}
