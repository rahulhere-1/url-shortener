package com.demo.url_shortner.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorMessage {

    private String message;
    private HttpStatus status;

}
