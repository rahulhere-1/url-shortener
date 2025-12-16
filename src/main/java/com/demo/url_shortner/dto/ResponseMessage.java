package com.demo.url_shortner.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ResponseMessage {

    Object data;
    HttpStatus status;
}
