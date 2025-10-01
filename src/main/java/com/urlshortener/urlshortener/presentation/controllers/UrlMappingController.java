package com.urlshortener.urlshortener.presentation.controllers;

import com.urlshortener.urlshortener.domain.UrlMapping;
import com.urlshortener.urlshortener.presentation.services.IUrlMappingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UrlMappingController {
    private final IUrlMappingService urlMappingService;

    @GetMapping
    public List<UrlMapping> getAll() {
       return this.urlMappingService.getAll();
    }

    @GetMapping("/{shortCode}")
    public RedirectView redirect(@PathVariable String shortCode) {
        var urlMapping = this.urlMappingService.getByShortCode(shortCode);

        if (urlMapping == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Short code not found");
        }

        return new RedirectView(urlMapping.getOriginalUrl());
    }

    @PostMapping
    public boolean add(@RequestBody UrlMapping urlMapping) {
        return this.urlMappingService.create(urlMapping);
    }

//    @PutMapping
//    public boolean update(@RequestBody UrlMapping urlMapping) {
//        return this.urlMappingService.update(urlMapping);
//    }

    @DeleteMapping
    public boolean delete(@RequestBody String id) {
        return this.urlMappingService.delete(UUID.fromString(id));
    }
}
