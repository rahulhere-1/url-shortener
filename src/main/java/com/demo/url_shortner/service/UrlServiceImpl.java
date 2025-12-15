package com.demo.url_shortner.service;

import com.demo.url_shortner.model.ShortLongURLRelation;
import com.demo.url_shortner.repo.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UrlServiceImpl implements UrlService {

    @Autowired
    private UrlRepository urlRepository;


    @Override
    public String getLongUrl(String shortUrl){
        ShortLongURLRelation urlObject = urlRepository.findById(shortUrl).orElseThrow(() -> new RuntimeException("Url Not Found"));
        return urlObject.getLongUrl();
    }

}
