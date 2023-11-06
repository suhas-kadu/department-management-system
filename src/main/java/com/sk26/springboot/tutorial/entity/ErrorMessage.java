package com.sk26.springboot.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {

    private HttpStatus status;
    private int statusCode;
    private String message;
}
