package com.urlshortener.urlshortener.presentation.services;

import com.urlshortener.urlshortener.domain.UrlMapping;

import java.util.List;
import java.util.UUID;

public interface IUrlMappingService {
   boolean create(UrlMapping url);
//   boolean update(UrlMapping url);
   boolean delete(UUID id);
   UrlMapping getByShortCode(String shortCode);
   List<UrlMapping> getAll();
}
