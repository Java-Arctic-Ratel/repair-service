package com.epam.repair.app.cucumber.steps;

import com.epam.repair.model.RepairOrder;
import com.epam.repair.service.RepairOrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

public class GetStepDefinitionTestCucumber {
    private ResponseEntity<RepairOrder> responseEntity = null;

    @Value("${url}")
    private String URL;

    @Autowired
    private RepairOrderService repairOrderService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Given("User wants to get order")
    public void userWantsToGetOrder() throws IOException {
        responseEntity = restTemplate.
                postForEntity(URL, repairOrderAddTest(), RepairOrder.class);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
    }

    @Then("The get by id 'IS SUCCESSFUL'")
    public void theGetByIdIsSuccessful() {
        int addOrderId = responseEntity.getBody().getRepairOrderId();
        responseEntity = restTemplate.
                getForEntity(URL + "/" + addOrderId, RepairOrder.class);
        int getById = responseEntity.getBody().getRepairOrderId();

        assertEquals(addOrderId, getById);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
    }

    @Then("But ID = {int} no in the database. The get by id 'IS UNSUCCESSFUL'")
    public void butIDNoInTheDatabaseTheGetByIdISUNSUCCESSFUL(int id1000) {
        assertThrows(HttpClientErrorException.class, () -> restTemplate.
                getForEntity(URL + "/" + id1000, RepairOrder.class));

    }

    private RepairOrder repairOrderAddTest() throws IOException {
        return repairOrderService
                .add(objectMapper.readValue(loadTestFile("json/newOrder.json"), RepairOrder.class));
    }
}
