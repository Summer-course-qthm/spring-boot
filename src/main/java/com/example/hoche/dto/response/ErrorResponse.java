package com.example.hoche.dto.response;

import lombok.*;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorResponse {
    String errorCode;
    String title;
    String msg;
}
