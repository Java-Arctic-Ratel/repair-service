package com.epam.repair.cucumber.runner;

import com.epam.repair.config.AbstractCucumberSpringConfigurationTest;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "pretty",
        features = "src/test/resources/features",
        glue = "com.epam.repair.cucumber.steps")
public class CucumberRunnerTest extends AbstractCucumberSpringConfigurationTest {
}