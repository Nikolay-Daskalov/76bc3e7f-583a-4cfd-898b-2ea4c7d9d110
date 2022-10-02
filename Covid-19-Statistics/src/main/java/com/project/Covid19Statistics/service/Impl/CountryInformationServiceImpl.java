package com.project.Covid19Statistics.service.Impl;

import com.project.Covid19Statistics.repository.CountryInformationRepository;
import com.project.Covid19Statistics.service.CountryInformationService;
import org.springframework.stereotype.Service;

@Service
public class CountryInformationServiceImpl implements CountryInformationService {

    private final CountryInformationRepository countryInformationRepository;

    public CountryInformationServiceImpl(CountryInformationRepository countryInformationRepository) {
        this.countryInformationRepository = countryInformationRepository;
    }
}
