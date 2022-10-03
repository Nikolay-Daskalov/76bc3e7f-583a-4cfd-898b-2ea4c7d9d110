package com.project.Covid19Statistics.model.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "country_info")
public class CountryInformationEntity {

    @Id
    @Type(type = "uuid-char")
    @Column(nullable = false)
    private UUID id;
    @Column(nullable = false, length = 31)
    private String country;
    @Column(nullable = false, length = 2)
    private String countryCode;
    @Column(nullable = false, length = 32)
    private String slug;
    @Column(nullable = false)
    private Integer newConfirmed;
    @Column(nullable = false)
    private Integer totalConfirmed;
    @Column(nullable = false)
    private Short newDeaths;
    @Column(nullable = false)
    private Integer totalDeaths;
    @Column(nullable = false)
    private Short newRecovered;
    @Column(nullable = false)
    private Short totalRecovered;
    @Column(nullable = false)
    private Instant date;

    public CountryInformationEntity() {
    }

    public UUID getId() {
        return id;
    }

    public CountryInformationEntity setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public CountryInformationEntity setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public CountryInformationEntity setCountryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    public String getSlug() {
        return slug;
    }

    public CountryInformationEntity setSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public Integer getNewConfirmed() {
        return newConfirmed;
    }

    public CountryInformationEntity setNewConfirmed(Integer newConfirmed) {
        this.newConfirmed = newConfirmed;
        return this;
    }

    public Integer getTotalConfirmed() {
        return totalConfirmed;
    }

    public CountryInformationEntity setTotalConfirmed(Integer totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
        return this;
    }

    public Short getNewDeaths() {
        return newDeaths;
    }

    public CountryInformationEntity setNewDeaths(Short newDeaths) {
        this.newDeaths = newDeaths;
        return this;
    }

    public Integer getTotalDeaths() {
        return totalDeaths;
    }

    public CountryInformationEntity setTotalDeaths(Integer totalDeaths) {
        this.totalDeaths = totalDeaths;
        return this;
    }

    public Short getNewRecovered() {
        return newRecovered;
    }

    public CountryInformationEntity setNewRecovered(Short newRecovered) {
        this.newRecovered = newRecovered;
        return this;
    }

    public Short getTotalRecovered() {
        return totalRecovered;
    }

    public CountryInformationEntity setTotalRecovered(Short totalRecovered) {
        this.totalRecovered = totalRecovered;
        return this;
    }

    public Instant getDate() {
        return date;
    }

    public CountryInformationEntity setDate(Instant date) {
        this.date = date;
        return this;
    }
}
