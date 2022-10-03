package com.project.Covid19Statistics.service.Impl;

import com.project.Covid19Statistics.model.entity.CountryInformationEntity;
import com.project.Covid19Statistics.model.service.CountryInformationServiceModel;
import com.project.Covid19Statistics.repository.CountryInformationRepository;
import com.project.Covid19Statistics.service.CountryInformationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryInformationServiceImpl implements CountryInformationService {

    private final CountryInformationRepository countryInformationRepository;
    private final ModelMapper modelMapper;

    public CountryInformationServiceImpl(CountryInformationRepository countryInformationRepository, ModelMapper modelMapper) {
        this.countryInformationRepository = countryInformationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addCountryInfo(CountryInformationServiceModel countryInformationServiceModel) {
        CountryInformationEntity countryInformationEntity = this.modelMapper.map(countryInformationServiceModel, CountryInformationEntity.class);
        this.countryInformationRepository.save(countryInformationEntity);
    }

    @Override
    public Optional<CountryInformationServiceModel> findCountryInfoByCountryCode(String countryCode) {
        Optional<CountryInformationEntity> countryByCountryCode = this.countryInformationRepository.findByCountryCode(countryCode);
        return countryByCountryCode.map(countryInformationEntity -> this.modelMapper.map(countryInformationEntity, CountryInformationServiceModel.class));
    }
}
