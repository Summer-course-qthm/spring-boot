package com.example.hoche.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatusCode;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppException extends RuntimeException{
    //properties
    private HttpStatusCode httpStatusCode;
    private String statusCode;
    private String title;
    private String msg;

}
