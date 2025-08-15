package com.example.hoche.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
    int statusCode;
    String title;
    String msg;
}
