package com.project.Covid19Statistics.model.binding;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CountryInformationHolderBindingModel(
        @JsonProperty("Countries")
        List<CountryInformationBindingModel> countries) {
}
