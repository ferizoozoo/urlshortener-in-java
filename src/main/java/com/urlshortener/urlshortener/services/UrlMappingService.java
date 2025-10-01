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
        url.generateShortCode(); // TODO: this doesn't imply that the shortCode field will be set
        return this.repository.add(url);
    }

//    @Override
//    public boolean update(UrlMapping url) {
//        var exists = this.repository.exists(url.getOriginalUrl());
//        if (exists) {
//            var oldUrl = this.repository.getByUrl(url.getOriginalUrl());
//            return this.repository.update(url);
//        }
//        return false;
//    }

    @Override
    public boolean delete(UUID id) {
        return this.repository.delete(id);
    }

    @Override
    public UrlMapping getByShortCode(String shortCode) {
        return this.repository.getByShortCode(shortCode);
    }

    @Override
    public List<UrlMapping> getAll() {
        return this.repository.getAll();
    }
}
