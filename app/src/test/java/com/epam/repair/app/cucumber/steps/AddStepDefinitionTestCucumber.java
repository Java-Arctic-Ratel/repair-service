package com.epam.repair.app.cucumber.steps;

import com.epam.repair.app.config.AbstractCucumberSpringConfigurationTest;
import com.epam.repair.model.RepairOrder;
import com.epam.repair.service.RepairOrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static com.epam.repair.app.utils.TestUtils.loadTestFile;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AddStepDefinitionTestCucumber extends AbstractCucumberSpringConfigurationTest {
    private ResponseEntity<RepairOrder> responseEntity = null;

    @Value("${url}")
    private String URL;

    @Autowired
    private RepairOrderService repairOrderService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Given("A new client brought a device.")
    public void newCustomerBroughtDevice() throws IOException {
        responseEntity = restTemplate.
                postForEntity(URL, repairOrderAddTest(), RepairOrder.class);
    }

    @When("Add a new client and device.")
    public void addNewClientAndDevice() {
        assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
    }

    @Then("The order is assigned a unique number.")
    public void theOrderIsAssignedUniqueNumber() {
        assertNotNull(responseEntity.getBody().getRepairOrderId());
        assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
    }

    @Then("Write the client firstName >= than {int} characters.")
    public void writeTheClientFirstNameMoreThanCharacters(int length) throws IOException {
        RepairOrder repairOrderAddValidMore40 = repairOrderAddTest();
        repairOrderAddValidMore40.getClient().setFirstName(generatedString(length));

        assertThrows(HttpClientErrorException.class, () -> restTemplate.
                postForEntity(URL, repairOrderAddValidMore40, RepairOrder.class));
    }

    @Then("Write the client firstName than {int} characters.")
    public void writeTheCustomerFirstName0(int length) throws IOException {
        RepairOrder repairOrderAddValidThan0 = repairOrderAddTest();
        repairOrderAddValidThan0.getClient().setFirstName(generatedString(length));

        assertThrows(HttpClientErrorException.class, () -> restTemplate.
                postForEntity(URL, repairOrderAddValidThan0, RepairOrder.class));
    }

    @Then("Save empty body - null.")
    public void saveEmptyBodyNull() {
        assertThrows(HttpClientErrorException.class, () -> restTemplate.
                postForEntity(URL, null, RepairOrder.class));
    }

    private RepairOrder repairOrderAddTest() throws IOException {
        return repairOrderService
                .add(objectMapper.readValue(loadTestFile("json/newOrder.json"), RepairOrder.class));
    }

    private String generatedString(int length) {
        return RandomStringUtils.random(length, true, true);
    }
}
