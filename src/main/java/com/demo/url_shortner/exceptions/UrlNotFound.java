package com.demo.url_shortner.exceptions;

public class UrlNotFound extends RuntimeException{

    public UrlNotFound(String message){
        super(message);
    }
}
