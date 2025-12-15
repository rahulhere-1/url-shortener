package com.demo.url_shortner.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {


    @ExceptionHandler(value = UrlNotFound.class)
    public ResponseEntity<ErrorMessage> handleNotFoundException(String message){

        ErrorMessage error = new ErrorMessage();
        error.setMessage(message);
        error.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(error, error.getStatus());

    }

}
