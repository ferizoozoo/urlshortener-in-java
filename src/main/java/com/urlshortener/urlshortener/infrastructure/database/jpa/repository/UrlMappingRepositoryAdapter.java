package com.urlshortener.urlshortener.infrastructure.database.jpa.repository;


import com.urlshortener.urlshortener.domain.UrlMapping;
import com.urlshortener.urlshortener.infrastructure.common.UrlMappingMapper;
import com.urlshortener.urlshortener.infrastructure.database.jpa.entities.UrlMappingEntity;
import com.urlshortener.urlshortener.services.repository.IUrlMappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

// NOTE: this interface is for working with spring jpa, the interface that we want is defined in
//          the application/service layer, and we've done this because of dependency inversion
//          between layers.
interface ISpringDataUrlMappingRepository extends CrudRepository<UrlMappingEntity, UUID> {
    UrlMappingEntity findByShortCode(String shortCode);
}

@Service
@RequiredArgsConstructor
public class UrlMappingRepositoryAdapter implements IUrlMappingRepository {
    private final ISpringDataUrlMappingRepository jpaRepository;
    private final UrlMappingMapper mapper; // A mapper to convert between domain and entity

    @Override
    public boolean add(UrlMapping urlMapping) {
        UrlMappingEntity urlMappingEntity = this.mapper.toEntity(urlMapping);
        this.jpaRepository.save(urlMappingEntity);
        return true;
    }

    // NOTE: although add and update are identical, but I decided for probable later changes, to repeat it.
    @Override
    public boolean update(UrlMapping urlMapping) {
        UrlMappingEntity urlMappingEntity = this.mapper.toEntity(urlMapping);
        this.jpaRepository.save(urlMappingEntity);
        return true;
    }

    @Override
    public boolean delete(UUID id) {
        this.jpaRepository.deleteById(id);
        return true;
    }

    @Override
    public UrlMapping getByShortCode(String shortCode) {
        var entity = this.jpaRepository.findByShortCode(shortCode);
        return UrlMappingMapper.toDomain(entity);
    }

    @Override
    public List<UrlMapping> getAll() {
        return StreamSupport.stream(this.jpaRepository.findAll().spliterator(), false)
                .map(UrlMappingMapper::toDomain)
                .collect(Collectors.toList());

    }
}

