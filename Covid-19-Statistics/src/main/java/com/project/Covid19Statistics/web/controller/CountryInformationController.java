package com.project.Covid19Statistics.web.controller;

import com.project.Covid19Statistics.model.service.CountryInformationServiceModel;
import com.project.Covid19Statistics.model.view.CountryInformationViewModel;
import com.project.Covid19Statistics.model.view.ErrorMessageViewModel;
import com.project.Covid19Statistics.service.CountryInformationService;
import com.project.Covid19Statistics.validation.CountryCodeValidator;
import com.project.Covid19Statistics.web.exception.CountryInfoException;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CountryInformationController {

    private static final String API_END_POINT = "/country/{countryCode}";

    private final CountryInformationService countryInformationService;
    private final ModelMapper modelMapper;

    public CountryInformationController(CountryInformationService countryInformationService, ModelMapper modelMapper) {
        this.countryInformationService = countryInformationService;
        this.modelMapper = modelMapper;
    }

    @GetMapping(path = API_END_POINT)
    public ResponseEntity<CountryInformationViewModel> getInfoByCountryCode(@PathVariable String countryCode) {

        boolean isCountryCodeValid = CountryCodeValidator.isValid(countryCode);

        if (!isCountryCodeValid) {
            throw new CountryInfoException("Country code must be exactly 2 characters long and all capital letters.", HttpStatus.BAD_REQUEST);
        }

        Optional<CountryInformationServiceModel> countryInfoByCountryCode = this.countryInformationService.findCountryInfoByCountryCode(countryCode);

        if (countryInfoByCountryCode.isEmpty()) {
            throw new CountryInfoException("Country could not be found.", HttpStatus.NOT_FOUND);
        }

        CountryInformationViewModel countryInformationViewModel = countryInfoByCountryCode
                .map(countryInfo -> this.modelMapper
                        .map(countryInfo, CountryInformationViewModel.class)).get();

        return ResponseEntity.ok(countryInformationViewModel);
    }

    @ExceptionHandler(CountryInfoException.class)
    public ResponseEntity<ErrorMessageViewModel> sendError(CountryInfoException countryInfoException){
        return ResponseEntity
                .status(countryInfoException.getHttpStatus())
                .body(new ErrorMessageViewModel(countryInfoException.getMessage()));
    }
}
