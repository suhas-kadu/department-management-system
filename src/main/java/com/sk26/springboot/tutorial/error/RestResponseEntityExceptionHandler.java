package com.sk26.springboot.tutorial.error;

import com.sk26.springboot.tutorial.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotException exception, WebRequest request) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, 404, exception.getMessage());

        return ResponseEntity.status(404).body(message);

    }
}
