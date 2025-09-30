package com.urlshortener.urlshortener.services;

import com.urlshortener.urlshortener.domain.UrlMapping;
import com.urlshortener.urlshortener.presentation.services.IUrlMappingService;
import com.urlshortener.urlshortener.services.repository.IUrlMappingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

// TODO: the service annotation should not be used in the application layer
@Service
public class UrlMappingService implements IUrlMappingService {
    private final IUrlMappingRepository repository;

    public UrlMappingService(IUrlMappingRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean create(UrlMapping url) {
        // TODO: maybe it should be checked, that no url like that exists
        url.generateShortCode();
        return this.repository.add(url);
    }

    @Override
    public boolean update(UrlMapping url) {
        return this.repository.update(url);
    }

    @Override
    public boolean delete(UUID id) {
        return this.repository.delete(id);
    }

    @Override
    public UrlMapping getById(UUID id) {
        return this.repository.getById(id);
    }

    @Override
    public List<UrlMapping> getAll() {
        return this.repository.getAll();
    }
}
