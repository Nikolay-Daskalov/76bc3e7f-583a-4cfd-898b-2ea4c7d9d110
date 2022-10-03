package com.project.Covid19Statistics.service;

import com.project.Covid19Statistics.model.service.CountryInformationServiceModel;

import java.util.Optional;

public interface CountryInformationService {

    void addCountryInfo(CountryInformationServiceModel countryInformationServiceModel);

    Optional<CountryInformationServiceModel> findCountryInfoByCountryCode(String countryCode);
}
