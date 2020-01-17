package com.epam.repair.app.cucumber.steps;

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
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UpdateStepDefinitionTestCucumber {
    private ResponseEntity<RepairOrder> responseEntity = null;

    @Value("${url}")
    private String URL;

    @Autowired
    private RepairOrderService repairOrderService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Given("Order is ready to issue.")
    public void orderIsReadyToIssue() throws IOException {
        responseEntity = restTemplate.
                postForEntity(URL, repairOrderAddTest(), RepairOrder.class);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
    }

    @Given("User need to edit the client first name in a order.")
    public void userNeedToEditTheClientFirstNameInAOrder() throws IOException {
        responseEntity = restTemplate.
                postForEntity(URL, repairOrderAddTest(), RepairOrder.class);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
    }

    @When("Find the order.")
    public void findTheOrder() throws IOException {
        responseEntity = restTemplate.
                getForEntity(URL + "/" + responseEntity.getBody().getRepairOrderId(), RepairOrder.class);
    }

    @Then("Change status --> {string}.")
    public void changeStatusInWork(String expectedStatus) {
        responseEntity.getBody().getStatus().setStatusId(3);

        restTemplate.put(URL, responseEntity.getBody());

        responseEntity = restTemplate.
                getForEntity(URL + "/" + responseEntity.getBody().getRepairOrderId(), RepairOrder.class);

        assertEquals(responseEntity.getBody().getStatus().getStatusName(), expectedStatus);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Then("Write the client lastName >= than {int} characters.")
    public void writeTheClientLastNameThanCharacters(int length) throws IOException {
        RepairOrder repairOrderAddValidMore40 = repairOrderAddTest();
        repairOrderAddValidMore40.getClient().setLastName(generatedString(length));

        assertThrows(HttpClientErrorException.class, () -> restTemplate.
                postForEntity(URL, repairOrderAddValidMore40, RepairOrder.class));
    }

    @Then("Write the client lastName than {int} characters.")
    public void writeTheCustomerLastName0(int length) throws IOException {
        RepairOrder repairOrderAddValidThan0 = repairOrderAddTest();
        repairOrderAddValidThan0.getClient().setLastName(generatedString(length));

        assertThrows(HttpClientErrorException.class, () -> restTemplate.
                postForEntity(URL, repairOrderAddValidThan0, RepairOrder.class));
    }

    private RepairOrder repairOrderAddTest() throws IOException {
        return repairOrderService
                .add(objectMapper.readValue(loadTestFile("json/newOrder.json"), RepairOrder.class));
    }

    private String generatedString(int length) {
        return RandomStringUtils.random(length, true, true);
    }
}
