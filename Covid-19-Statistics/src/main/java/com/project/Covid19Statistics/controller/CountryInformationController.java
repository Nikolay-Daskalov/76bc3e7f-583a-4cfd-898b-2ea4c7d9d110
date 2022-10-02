package com.project.Covid19Statistics.controller;

import com.project.Covid19Statistics.service.CountryInformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/country")
public class CountryInformationController {

    private final CountryInformationService countryInformationService;

    public CountryInformationController(CountryInformationService countryInformationService) {
        this.countryInformationService = countryInformationService;
    }

    @GetMapping(path = "/{countryCode}")
    public ResponseEntity<?> getInfoByCountryCode(@PathVariable String countryCode) {

        return null;
    }
}
