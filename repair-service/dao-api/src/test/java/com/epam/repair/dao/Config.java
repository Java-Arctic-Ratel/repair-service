package com.epam.repair.dao;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@EnableAutoConfiguration
@EntityScan(basePackages = "com.epam.repair.model")
@ComponentScan(basePackages = "com.epam.repair.dao")
public class Config {
}
