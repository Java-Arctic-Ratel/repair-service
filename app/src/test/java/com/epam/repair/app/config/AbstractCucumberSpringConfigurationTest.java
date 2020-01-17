package com.epam.repair.app.config;

import com.epam.repair.app.AppApplication;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;


@ActiveProfiles("dev")
@SpringBootTest(classes = AppApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = TestConfig.class)
public class AbstractCucumberSpringConfigurationTest {
}
