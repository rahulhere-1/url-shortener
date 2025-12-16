package com.demo.url_shortner.dto;


import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;


@Data
public class ShortUrlRequest {

    private String shortUrl;

    private String longUrl;

    private Date createdOn;
}
