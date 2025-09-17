package com.example.userTest.DTO.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {
    private String name;
    private Integer age;
    private String role;
    private String address;
    private String username;
    private String password;
}
