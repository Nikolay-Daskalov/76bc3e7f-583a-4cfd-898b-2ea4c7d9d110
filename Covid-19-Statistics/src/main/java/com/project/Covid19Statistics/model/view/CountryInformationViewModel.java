package com.project.Covid19Statistics.model.view;

public record CountryInformationViewModel(
        String id,
        String country,
        String countryCode,
        String slug,
        Integer newConfirmed,
        Integer totalConfirmed,
        Short newDeaths,
        Integer totalDeaths,
        Short newRecovered,
        Short totalRecovered,
        String date) {
}
