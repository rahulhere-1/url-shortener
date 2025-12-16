package com.demo.url_shortner.service;

import com.demo.url_shortner.dto.ResponseMessage;
import com.demo.url_shortner.dto.ShortUrlRequest;
import com.demo.url_shortner.exceptions.UrlNotFound;
import com.demo.url_shortner.model.ShortLongURLRelation;
import com.demo.url_shortner.repo.UrlRepository;
import com.demo.url_shortner.util.Constant;
import com.demo.url_shortner.util.MD5HashGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UrlServiceImpl implements UrlService {

    private static final Logger logger = Logger.getLogger(UrlServiceImpl.class.getName());
    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    private MD5HashGenerator hashGenerator;
    @Override
    public String getLongUrl(String shortUrl){
        String hash = shortUrl.substring(shortUrl.lastIndexOf("/")+1);
        ShortLongURLRelation urlObject = urlRepository.findById(hash).orElseThrow(() -> new UrlNotFound("Url Not Found"));
        return urlObject.getLongUrl();
    }

    @Override
    public ResponseMessage generateShortUrl(ShortUrlRequest shortUrlRequestBody){
        String longUrl = shortUrlRequestBody.getLongUrl();
        ResponseMessage response = new ResponseMessage();
        Optional<ShortLongURLRelation> urlOject = urlRepository.findByLongUrl(longUrl);
        if(urlOject.isPresent()){
            shortUrlRequestBody.setShortUrl(Constant.WEBSITE.concat(urlOject.get().getShortUrl()));
            response.setStatus(HttpStatus.OK);
        }
        else {
            String hash = hashGenerator.generateHashValue(longUrl).substring(0, 7);

            while (!isAvailable(hash)) {
                hash = hashGenerator.generateHashValue(hash).substring(0, 7);
            }
            ShortLongURLRelation shortLongURLRelation = new ShortLongURLRelation();
            shortLongURLRelation.setShortUrl(hash);
            shortLongURLRelation.setLongUrl(longUrl);
            shortLongURLRelation.setCreatedOn(Calendar.getInstance().getTime());
            urlRepository.save(shortLongURLRelation);
            String shortUrl = Constant.WEBSITE.concat(hash);
            logger.info("generated short url [ " + shortUrl + " ]");
            shortUrlRequestBody.setShortUrl(shortUrl);
            response.setStatus(HttpStatus.CREATED);
        }
        response.setData(shortUrlRequestBody);
        return response;
    }

    private boolean isAvailable(String hash){
        Optional<ShortLongURLRelation> urlObject = urlRepository.findById(hash);
        return urlObject.isEmpty();
    }

}
