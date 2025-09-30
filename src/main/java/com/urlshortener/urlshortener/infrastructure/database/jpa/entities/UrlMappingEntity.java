package com.urlshortener.urlshortener.infrastructure.database.jpa.entities;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;
import java.util.UUID;

@Entity
public class UrlMappingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String originalUrl;

    private String shortCode;

    private Date createdAt;

    private int visitCount;

    protected UrlMappingEntity() {
    }

    public UrlMappingEntity(String originalUrl, String shortCode) {
        this.originalUrl = originalUrl;
        this.shortCode = shortCode;
    }

    @Override
    public String toString() {
        return String.format(
                "UrlMapping[id=%s, originalUrl='%s', shortCode='%s', createdAt=%s, visitCount=%d]",
                id, originalUrl, shortCode, createdAt, visitCount);
    }

    public UUID getId() {
        return id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public String getShortCode() {
        return shortCode;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public int getVisitCount() {
        return visitCount;
    }
}
