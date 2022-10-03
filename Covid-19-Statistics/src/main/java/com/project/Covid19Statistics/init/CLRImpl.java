package com.project.Covid19Statistics.init;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.Covid19Statistics.model.binding.CountryInformationBindingModel;
import com.project.Covid19Statistics.model.binding.CountryInformationHolderBindingModel;
import com.project.Covid19Statistics.model.service.CountryInformationServiceModel;
import com.project.Covid19Statistics.service.CountryInformationService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class CLRImpl implements CommandLineRunner {

    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    private static final String DATA_URL = "https://api.covid19api.com/summary";

    private final CountryInformationService countryInformationService;
    private final ObjectMapper objectMapper;
    private final ModelMapper modelMapper;

    public CLRImpl(CountryInformationService countryInformationService, ObjectMapper objectMapper, ModelMapper modelMapper) {
        this.countryInformationService = countryInformationService;
        this.objectMapper = objectMapper;
        this.modelMapper = modelMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Downloading and processing data...");

        ResponseEntity<String> response = REST_TEMPLATE.getForEntity(DATA_URL, String.class);
        CountryInformationHolderBindingModel countriesInfo = this.objectMapper.readValue(response.getBody(), CountryInformationHolderBindingModel.class);

        for (CountryInformationBindingModel countryInfo : countriesInfo.countries()) {
            CountryInformationServiceModel countryInfoServiceModel = this.modelMapper.map(countryInfo, CountryInformationServiceModel.class);
            this.countryInformationService.addCountryInfo(countryInfoServiceModel);
        }

        System.out.println("\n------------------------------------------------\n");
        log.info("Everything was processed successfully.");
    }
}
