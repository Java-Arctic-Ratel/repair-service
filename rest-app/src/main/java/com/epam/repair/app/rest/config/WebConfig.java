package com.epam.repair.app.rest.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Profile({"rest"})
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Value("${cors.addMapping}")
    private String addMapping;
    @Value("${cors.allowedOrigins}")
    private String allowedOrigins;
    @Value("${cors.allowedMethods}")
    private String allowedMethods;
    @Value("${cors.allowedHeaders}")
    private String allowedHeaders;
    @Value("${cors.allowCredentials}")
    private Boolean allowCredentials;
    @Value("${cors.maxAge}")
    private Integer maxAge;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping(addMapping)
                .allowedOrigins(allowedOrigins)
                .allowedMethods(allowedMethods.split(","))
                .allowedHeaders(allowedHeaders)
                .allowCredentials(allowCredentials)
                .maxAge(maxAge);
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
        registrar.setUseIsoFormat(true);
        registrar.registerFormatters(registry);
    }

    @Bean
    public LocalValidatorFactoryBean validator(MessageSource messageSource) {
        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
        validatorFactoryBean.setValidationMessageSource(messageSource);
        return validatorFactoryBean;
    }
}
