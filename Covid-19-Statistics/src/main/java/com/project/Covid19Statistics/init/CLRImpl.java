package com.project.Covid19Statistics.init;

import com.project.Covid19Statistics.service.CountryInformationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CLRImpl implements CommandLineRunner {

    private final RestTemplate restTemplate = new RestTemplate();

    private final CountryInformationService countryInformationService;

    public CLRImpl(CountryInformationService countryInformationService) {
        this.countryInformationService = countryInformationService;
    }

    @Override
    public void run(String... args) throws Exception {
        //TODO: get data from endpoint - [https://api.covid19api.com/summary]
        System.out.println("CLR working");
    }
}
