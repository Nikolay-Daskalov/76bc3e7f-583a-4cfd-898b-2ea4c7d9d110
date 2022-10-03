package com.project.Covid19Statistics.config;

import com.project.Covid19Statistics.model.binding.CountryInformationBindingModel;
import com.project.Covid19Statistics.model.service.CountryInformationServiceModel;
import com.project.Covid19Statistics.model.view.CountryInformationViewModel;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;
import java.util.UUID;

@Configuration
public class GeneralConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(new AbstractConverter<CountryInformationBindingModel, CountryInformationServiceModel>() {
            @Override
            protected CountryInformationServiceModel convert(CountryInformationBindingModel source) {
                CountryInformationServiceModel countryInfoServiceModel = new CountryInformationServiceModel();
                countryInfoServiceModel
                        .setId(UUID.fromString(source.id()))
                        .setCountry(source.country())
                        .setCountryCode(source.countryCode())
                        .setSlug(source.slug())
                        .setNewConfirmed(source.newConfirmed())
                        .setTotalConfirmed(source.totalConfirmed())
                        .setNewDeaths(source.newDeaths())
                        .setTotalDeaths(source.totalDeaths())
                        .setNewRecovered(source.newRecovered())
                        .setTotalRecovered(source.totalRecovered())
                        .setDate(Instant.parse(source.date()));

                return countryInfoServiceModel;
            }
        });
        modelMapper.addConverter(new AbstractConverter<CountryInformationServiceModel, CountryInformationViewModel>() {
            @Override
            protected CountryInformationViewModel convert(CountryInformationServiceModel source) {

                return new CountryInformationViewModel(
                        source.getId().toString(),
                        source.getCountry(),
                        source.getCountryCode(),
                        source.getSlug(),
                        source.getNewConfirmed(),
                        source.getTotalConfirmed(),
                        source.getNewDeaths(),
                        source.getTotalDeaths(),
                        source.getNewRecovered(),
                        source.getTotalRecovered(),
                        source.getDate().toString()
                );
            }
        });
        return modelMapper;
    }
}
