package com.demo.url_shortner.controller;

import com.demo.url_shortner.dto.ShortUrlRequest;
import com.demo.url_shortner.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UrlController {

    @Autowired
    private UrlService urlService;

    @GetMapping("/getLongUrl")
    public ResponseEntity<String> getLongUrl(@RequestParam String shortUrl){
        String longUrl = urlService.getLongUrl(shortUrl);
        return new ResponseEntity<>(longUrl, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> generateShortUrl(@RequestBody ShortUrlRequest shortUrlRequest){

        return new ResponseEntity<>("successfully created.... ",HttpStatus.CREATED);
    }
}
