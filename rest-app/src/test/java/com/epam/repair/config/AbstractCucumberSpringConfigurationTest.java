package com.epam.repair.config;

import com.epam.repair.rest.RestApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(classes = RestApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("dev")
@ContextConfiguration(classes = TestConfig.class)
public class AbstractCucumberSpringConfigurationTest {
}