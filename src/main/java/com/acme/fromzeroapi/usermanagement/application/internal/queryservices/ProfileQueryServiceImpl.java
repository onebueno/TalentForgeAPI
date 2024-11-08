package com.acme.fromzeroapi.usermanagement.application.internal.queryservices;

import com.acme.fromzeroapi.usermanagement.domain.model.aggregates.Developer;
import com.acme.fromzeroapi.usermanagement.domain.model.aggregates.Enterprise;
import com.acme.fromzeroapi.usermanagement.domain.model.queries.*;
import com.acme.fromzeroapi.usermanagement.domain.services.ProfileQueryService;
import com.acme.fromzeroapi.usermanagement.infraestructure.persistence.jpa.repositories.DeveloperRepository;
import com.acme.fromzeroapi.usermanagement.infraestructure.persistence.jpa.repositories.EnterpriseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileQueryServiceImpl implements ProfileQueryService {
    private final DeveloperRepository developerRepository;
    private final EnterpriseRepository enterpriseRepository;

    public ProfileQueryServiceImpl(DeveloperRepository developerRepository, EnterpriseRepository enterpriseRepository) {
        this.developerRepository = developerRepository;
        this.enterpriseRepository = enterpriseRepository;
    }

    @Override
    public List<Developer> handle(GetAllDevelopersAsyncQuery query) {
        return developerRepository.findAll();
    }

    @Override
    public Optional<Developer> handle(GetDeveloperByUserIdAsyncQuery query) {
        return developerRepository.findDeveloperByUserUserId(query.id());
    }

    @Override
    public Optional<Enterprise> handle(GetEnterpriseByUserIdAsyncQuery query) {
        return enterpriseRepository.findEnterpriseByUserUserId(query.id());
    }

    @Override
    public Optional<Enterprise> handle(GetEnterpriseByIdQuery query) {
        return this.enterpriseRepository.findById(query.enterpriseId());
    }

    @Override
    public Optional<Developer> handle(GetDeveloperByIdQuery query) {
        return this.developerRepository.findById(query.developerId());
    }
}
