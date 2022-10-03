package com.project.Covid19Statistics.model.service;


import java.time.Instant;
import java.util.UUID;

public class CountryInformationServiceModel {

    private UUID id;
    private String country;
    private String countryCode;
    private String slug;
    private Integer newConfirmed;
    private Integer totalConfirmed;
    private Short newDeaths;
    private Integer totalDeaths;
    private Short newRecovered;
    private Short totalRecovered;
    private Instant date;

    public CountryInformationServiceModel() {
    }

    public UUID getId() {
        return id;
    }

    public CountryInformationServiceModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public CountryInformationServiceModel setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public CountryInformationServiceModel setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public CountryInformationServiceModel setSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public Integer getNewConfirmed() {
        return newConfirmed;
    }

    public CountryInformationServiceModel setNewConfirmed(Integer newConfirmed) {
        this.newConfirmed = newConfirmed;
        return this;
    }

    public Integer getTotalConfirmed() {
        return totalConfirmed;
    }

    public CountryInformationServiceModel setTotalConfirmed(Integer totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
        return this;
    }

    public Short getNewDeaths() {
        return newDeaths;
    }

    public CountryInformationServiceModel setNewDeaths(Short newDeaths) {
        this.newDeaths = newDeaths;
        return this;
    }

    public Integer getTotalDeaths() {
        return totalDeaths;
    }

    public CountryInformationServiceModel setTotalDeaths(Integer totalDeaths) {
        this.totalDeaths = totalDeaths;
        return this;
    }

    public Short getNewRecovered() {
        return newRecovered;
    }

    public CountryInformationServiceModel setNewRecovered(Short newRecovered) {
        this.newRecovered = newRecovered;
        return this;
    }

    public Short getTotalRecovered() {
        return totalRecovered;
    }

    public CountryInformationServiceModel setTotalRecovered(Short totalRecovered) {
        this.totalRecovered = totalRecovered;
        return this;
    }

    public Instant getDate() {
        return date;
    }

    public CountryInformationServiceModel setDate(Instant date) {
        this.date = date;
        return this;
    }
}
