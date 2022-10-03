package com.project.Covid19Statistics.model.binding;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CountryInformationBindingModel(
        @JsonProperty("ID")
        String id,
        @JsonProperty("Country")
        String country,
        @JsonProperty("CountryCode")
        String countryCode,
        @JsonProperty("Slug")
        String slug,
        @JsonProperty("NewConfirmed")
        Integer newConfirmed,
        @JsonProperty("TotalConfirmed")
        Integer totalConfirmed,
        @JsonProperty("NewDeaths")
        Short newDeaths,
        @JsonProperty("TotalDeaths")
        Integer totalDeaths,
        @JsonProperty("NewRecovered")
        Short newRecovered,
        @JsonProperty("TotalRecovered")
        Short totalRecovered,
        @JsonProperty("Date")
        String date) {
}
