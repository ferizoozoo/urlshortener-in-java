package com.urlshortener.urlshortener.infrastructure.common;

import com.urlshortener.urlshortener.domain.UrlMapping;
import com.urlshortener.urlshortener.infrastructure.database.jpa.entities.UrlMappingEntity;
import org.springframework.stereotype.Service;

@Service
public class UrlMappingMapper {
    public static UrlMappingEntity toEntity(UrlMapping domain) {
        var originalUrl = domain.getOriginalUrl();
        var shortCode = domain.getShortCode();
        return new UrlMappingEntity(
                originalUrl,
                shortCode
        );
    }

    public static UrlMapping toDomain(UrlMappingEntity entity) {
        var id = entity.getId();
        var originalUrl = entity.getOriginalUrl();
        var shortCode = entity.getShortCode();
        var createdAt = entity.getCreatedAt();
        var visitCount = entity.getVisitCount();

        return new UrlMapping(
                id,
                originalUrl,
                shortCode,
                createdAt,
                visitCount
        );
    }
}
