package com.project.Covid19Statistics.service.Impl;

import com.project.Covid19Statistics.model.entity.CountryInformationEntity;
import com.project.Covid19Statistics.model.service.CountryInformationServiceModel;
import com.project.Covid19Statistics.repository.CountryInformationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CountryInformationServiceImplTest {

    private CountryInformationServiceImpl countryInformationService;

    private CountryInformationRepository countryInformationRepository;
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        this.countryInformationRepository = mock(CountryInformationRepository.class);
        this.modelMapper = mock(ModelMapper.class);
        this.countryInformationService = new CountryInformationServiceImpl(this.countryInformationRepository, this.modelMapper);
    }

    @AfterEach
    void tearDown() {
        this.countryInformationRepository = null;
        this.modelMapper = null;
        this.countryInformationService = null;
    }

    @Test
    void shouldReturnOptionalWithTheFoundCountry(){

        final UUID uuid = UUID.randomUUID();
        final String country = "Bulgaria";
        final String countryCode = "BG";
        final String slug = "bulgaria";
        final Integer newConfirmed = 100;
        final Integer totalConfirmed = 1000;
        final Short newDeaths = 10;
        final Integer totalDeaths = 100;
        final Short newRecovered = 15;
        final Short totalRecovered = 500;
        final Instant date = Instant.now();

        CountryInformationEntity countryInformationEntity = new CountryInformationEntity();
        countryInformationEntity
                .setId(uuid)
                .setCountry(country)
                .setCountryCode(countryCode)
                .setSlug(slug)
                .setNewConfirmed(newConfirmed)
                .setTotalConfirmed(totalConfirmed)
                .setNewDeaths(newDeaths)
                .setTotalDeaths(totalDeaths)
                .setNewRecovered(newRecovered)
                .setTotalRecovered(totalRecovered)
                .setDate(date);

        when(this.countryInformationRepository.findByCountryCode(countryCode)).thenReturn(Optional.of(countryInformationEntity));

        CountryInformationServiceModel countryInformationServiceModel = new CountryInformationServiceModel();
        countryInformationServiceModel
                .setId(uuid)
                .setCountry(country)
                .setCountryCode(countryCode)
                .setSlug(slug)
                .setNewConfirmed(newConfirmed)
                .setTotalConfirmed(totalConfirmed)
                .setNewDeaths(newDeaths)
                .setTotalDeaths(totalDeaths)
                .setNewRecovered(newRecovered)
                .setTotalRecovered(totalRecovered)
                .setDate(date);

        when(this.modelMapper.map(same(countryInformationEntity), same(CountryInformationServiceModel.class))).thenReturn(countryInformationServiceModel);

        Optional<CountryInformationServiceModel> actual = this.countryInformationService.findCountryInfoByCountryCode(countryCode);

        assertTrue(actual.isPresent(), "Optional must not be empty.");

        CountryInformationServiceModel actualServiceModel = actual.get();

        assertAll(() -> {
            if (!actualServiceModel.getId().toString().equals(uuid.toString())){
                throw new RuntimeException("UUIDs are not the same.");
            }
            if (!actualServiceModel.getCountry().equals(country)){
                throw new RuntimeException("Countries are not the same.");
            }
            if (!actualServiceModel.getCountryCode().equals(countryCode)){
                throw new RuntimeException("Country codes are not the same.");
            }
            if (!actualServiceModel.getSlug().equals(slug)){
                throw new RuntimeException("Slugs are not the same.");
            }
            if (!actualServiceModel.getNewConfirmed().equals(newConfirmed)){
                throw new RuntimeException("NewConfirmed are not the same.");
            }
            if (!actualServiceModel.getTotalConfirmed().equals(totalConfirmed)){
                throw new RuntimeException("TotalConfirmed are not the same.");
            }
            if (!actualServiceModel.getNewDeaths().equals(newDeaths)){
                throw new RuntimeException("NewDeaths are not the same.");
            }
            if (!actualServiceModel.getTotalDeaths().equals(totalDeaths)){
                throw new RuntimeException("TotalDeaths are not the same.");
            }
            if (!actualServiceModel.getNewRecovered().equals(newRecovered)){
                throw new RuntimeException("NewRecovered are not the same.");
            }
            if (!actualServiceModel.getTotalRecovered().equals(totalRecovered)){
                throw new RuntimeException("TotalConfirmed are not the same.");
            }
            if (!actualServiceModel.getDate().toString().equals(date.toString())){
                throw new RuntimeException("Dates are not the same.");
            }
        });
    }

    @Test
    void shouldReturnEmptyOptionalForCountryInfoNotFound(){
        final String countryCode = "BG";
        when(this.countryInformationRepository.findByCountryCode(eq(countryCode))).thenReturn(Optional.empty());

        Optional<CountryInformationServiceModel> countryInfoByCountryCode = this.countryInformationService.findCountryInfoByCountryCode(countryCode);

        assertTrue(countryInfoByCountryCode.isEmpty(), "Optional should be empty.");
    }

}