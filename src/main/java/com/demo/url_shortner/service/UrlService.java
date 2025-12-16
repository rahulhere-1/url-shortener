package com.demo.url_shortner.service;

import com.demo.url_shortner.dto.ShortUrlRequest;

public interface UrlService {
    String getLongUrl(String shortUrl);

    String generateShortUrl(ShortUrlRequest shortUrlRequestBody);
}
