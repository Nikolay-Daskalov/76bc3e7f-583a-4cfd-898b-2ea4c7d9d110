package com.project.Covid19Statistics.web.controller;

import com.project.Covid19Statistics.model.service.CountryInformationServiceModel;
import com.project.Covid19Statistics.model.view.CountryInformationViewModel;
import com.project.Covid19Statistics.service.CountryInformationService;
import com.project.Covid19Statistics.web.exception.CountryInfoException;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

@WebMvcTest(CountryInformationController.class)
class CountryInformationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryInformationService countryInformationService;
    @MockBean
    private ModelMapper modelMapper;

    void checkEndPointsResponseBodyForFailedInput(String[] endPointUrls) throws Exception {
        final String responseBodyMessage = "Country code must be exactly 2 characters long and all capital letters.";

        for (String endPointUrl : endPointUrls) {
            this.mockMvc
                    .perform(get(endPointUrl))
                    .andExpect(status().isBadRequest())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andExpect(result -> {
                        assertInstanceOf(CountryInfoException.class, result.getResolvedException());
                        assertEquals(responseBodyMessage, result.getResolvedException().getMessage());
                    })
                    .andExpect(jsonPath("$.message").exists())
                    .andExpect(jsonPath("$.message").isString())
                    .andExpect(jsonPath("$.message").value(responseBodyMessage));
        }
    }

    @Test
    void shouldReturn400StatusForPathVariableContainingNonCapitalLetters() throws Exception {
        final String[] endPointUrls = new String[]{
                "/country/Bg", "/country/dE", "/country/de"
        };

        checkEndPointsResponseBodyForFailedInput(endPointUrls);
    }

    @Test
    void shouldReturn400StatusForPathVariableCharactersLengthAreNotEqualTo2() throws Exception {
        final String[] endPointUrls = new String[]{
                "/country/B", "/country/DEE", "/country/BGDE"
        };

        checkEndPointsResponseBodyForFailedInput(endPointUrls);
    }

    @Test
    void shouldReturn400StatusForPathVariableContainingNonLetters() throws Exception {
        final String[] endPointUrls = new String[]{
                "/country/B1", "/country/DE!", "/country/$"
        };

        checkEndPointsResponseBodyForFailedInput(endPointUrls);
    }

    @Test
    void shouldReturn404StatusForCountryNotFound() throws Exception {
        final String countryCode = "BG";
        final String endPointUrl = "/country/" + countryCode;

        when(this.countryInformationService.findCountryInfoByCountryCode(eq(endPointUrl))).thenReturn(Optional.empty());

        final String responseBodyMessage = "Country could not be found.";

        this.mockMvc
                .perform(get(endPointUrl))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(result -> {
                    assertInstanceOf(CountryInfoException.class, result.getResolvedException());
                    assertEquals(responseBodyMessage, result.getResolvedException().getMessage());
                })
                .andExpect(jsonPath("$.message").exists())
                .andExpect(jsonPath("$.message").isString())
                .andExpect(jsonPath("$.message").value(responseBodyMessage));
    }

    @Test
    void shouldReturnDataWithCorrectRequest() throws Exception {
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

        final Optional<CountryInformationServiceModel> countryInfoByCountryCode = Optional.of(
                new CountryInformationServiceModel()
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
                        .setDate(date)
        );

        when(this.countryInformationService.findCountryInfoByCountryCode(eq(countryCode))).thenReturn(countryInfoByCountryCode);

        when(this.modelMapper.map(eq(countryInfoByCountryCode.get()), same(CountryInformationViewModel.class))).thenReturn(
                new CountryInformationViewModel(
                        uuid.toString(),
                        country,
                        countryCode,
                        slug,
                        newConfirmed,
                        totalConfirmed,
                        newDeaths,
                        totalDeaths,
                        newRecovered,
                        totalRecovered,
                        date.toString())
        );

        final String endPointUrl = "/country/" + countryCode;

        this.mockMvc
                .perform(get(endPointUrl))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.id").value(uuid.toString()))
                .andExpect(jsonPath("$.country").value(country))
                .andExpect(jsonPath("$.countryCode").value(countryCode))
                .andExpect(jsonPath("$.slug").value(slug))
                .andExpect(jsonPath("$.newConfirmed").value(newConfirmed))
                .andExpect(jsonPath("$.totalConfirmed").value(totalConfirmed))
                .andExpect(jsonPath("$.newDeaths").value(newDeaths.intValue()))
                .andExpect(jsonPath("$.totalDeaths").value(totalDeaths))
                .andExpect(jsonPath("$.newRecovered").value(newRecovered.intValue()))
                .andExpect(jsonPath("$.totalRecovered").value(totalRecovered.intValue()))
                .andExpect(jsonPath("$.date").value(date.toString()));
    }
}