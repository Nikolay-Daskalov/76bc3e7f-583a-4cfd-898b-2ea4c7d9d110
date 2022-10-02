package com.project.Covid19Statistics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GeneralConfig {

    @Bean
    public RestTemplate restTemplate(){//TODO: maybe remove if not using it as bean
        return new RestTemplate();
    }
}
