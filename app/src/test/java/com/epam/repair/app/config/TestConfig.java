package com.epam.repair.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(basePackages = "com.epam.repair")
public class TestConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
