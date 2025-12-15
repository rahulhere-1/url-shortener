package com.demo.url_shortner.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "short_long_url_relation")
@Data
public class ShortLongURLRelation {

    @Column(name = "short_url")
    @Id
    private String shortUrl;

    @Column(name = "long_url")
    private String longUrl;

    @Column(name = "created_on")
    private Date createdOn;


}
