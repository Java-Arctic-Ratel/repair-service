package com.epam.repair.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@EntityScan(basePackages = "com.epam.repair.model")
public class TestConfig {

    @Bean
    public ObjectMapper objectMapper (){
       return new ObjectMapper();
    }
}