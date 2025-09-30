package com.urlshortener.urlshortener.services.repository;

import com.urlshortener.urlshortener.domain.UrlMapping;
import com.urlshortener.urlshortener.infrastructure.database.jpa.entities.UrlMappingEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUrlMappingRepository {
    public boolean exists(String url);
    public boolean add(UrlMapping urlMapping);
    public boolean update(UrlMapping urlMapping);
    public boolean delete(UUID id);
    public UrlMapping getById(UUID id);
    public List<UrlMapping> getAll();
}
