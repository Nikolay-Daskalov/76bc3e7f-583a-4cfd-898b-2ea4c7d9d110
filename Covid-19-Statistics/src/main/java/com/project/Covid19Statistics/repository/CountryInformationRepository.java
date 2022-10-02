package com.project.Covid19Statistics.repository;

import com.project.Covid19Statistics.model.entity.country.CountryInformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CountryInformationRepository extends JpaRepository<CountryInformationEntity, UUID> {
}
