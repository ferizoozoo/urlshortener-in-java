package com.urlshortener.urlshortener.domain;

import com.urlshortener.urlshortener.services.utils.ShortCodeGenerator;

import java.util.Date;
import java.util.UUID;

public class UrlMapping {
    private UUID id;
    private String originalUrl;
    private String shortCode;
    private Date createdAt;
    private int visitCount;

    public UrlMapping() {}

    public UrlMapping(String originalUrl, String shortCode) {
        this.originalUrl = originalUrl;
        this.shortCode = ShortCodeGenerator.generate();
    }

    public UrlMapping(UUID id, String originalUrl, String shortCode, Date createdAt, int visitCount) {
        this.id = id;
        this.originalUrl = originalUrl;
        this.shortCode = shortCode;
        this.createdAt = createdAt;
        this.visitCount = visitCount;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public boolean generateShortCode() {
        this.shortCode = ShortCodeGenerator.generate();
        return true;
    }
}
