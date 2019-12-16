package com.epam.repair.config;

import com.epam.repair.rest.RestApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(classes = RestApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("dev")
public class AbstractCucumberSpringConfigurationTest {
    protected static final String URL = "http://localhost:8090/order";
    protected RestTemplate restTemplate = new RestTemplate();
}