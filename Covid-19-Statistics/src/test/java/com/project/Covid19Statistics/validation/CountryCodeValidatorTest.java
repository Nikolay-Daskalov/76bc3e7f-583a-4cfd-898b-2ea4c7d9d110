package com.project.Covid19Statistics.validation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CountryCodeValidatorTest {


    private void checkResultsForFailure(String[] countryCodes, String message){
        for (String countryCode : countryCodes) {
            boolean result = CountryCodeValidator.isValid(countryCode);

            assertFalse(result, message);
        }
    }

    @Test
    void shouldFailForCharacterLengthNotEqualTo2() {
        final String[] countryCodes = new String[]{
                "BGG", "B", "", "BGDE"
        };

        checkResultsForFailure(countryCodes, "Country code length should be exactly 2.");
    }

    @Test
    void shouldFailForNonLetters() {
        final String[] countryCodes = new String[]{
                "B1", "!B", "12", "D;"
        };

        checkResultsForFailure(countryCodes, "Country code should not contain any characters that are not letters.");
    }

    @Test
    void shouldFailForLowerCaseCharacters() {
        final String[] countryCodes = new String[]{
                "Bg", "dE"
        };

        checkResultsForFailure(countryCodes, "Country code should not contain any characters that are not Capital Letters.");
    }

    @Test
    void shouldPassForCorrectCountryCode() {
        final String[] countryCodes = new String[]{
                "BG", "DE", "FR"
        };

        for (String countryCode : countryCodes) {
            boolean result = CountryCodeValidator.isValid(countryCode);

            assertTrue(result, "Country code be valid.");
        }
    }
}