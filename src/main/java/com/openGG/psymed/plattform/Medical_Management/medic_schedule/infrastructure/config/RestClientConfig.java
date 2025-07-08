package com.openGG.psymed.plattform.Medical_Management.medic_schedule.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class for REST client components.
 * <p>
 * This configuration defines the {@link RestTemplate} bean,
 * which is used for making HTTP requests to external services such as ACL facades.
 * </p>
 */

@Configuration
public class RestClientConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}