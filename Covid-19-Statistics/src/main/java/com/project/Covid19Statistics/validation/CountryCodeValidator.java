package com.project.Covid19Statistics.validation;


public class CountryCodeValidator {

    public static boolean isValid(String countryCode){
        if (countryCode.length() != 2){
            return false;
        }

        if (!countryCode.chars().allMatch(Character::isAlphabetic)){
            return false;
        }

        if (!countryCode.equals(countryCode.toUpperCase())){
            return false;
        }

        return true;
    }
}
