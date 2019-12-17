package com.epam.repair.cucumber.steps;

import com.epam.repair.model.RepairOrder;
import com.epam.repair.service.RepairOrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static com.epam.repair.utils.TestUtils.loadTestFile;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeleteStepDefinitionTestCucumber {
    private ResponseEntity<RepairOrder> responseEntity = null;

    @Value("${url}")
    private String URL;

    @Autowired
    private RepairOrderService repairOrderService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Given("User wants to delete order.")
    public void userWantsToDeleteOrder() throws IOException {
        responseEntity = restTemplate.
                postForEntity(URL, repairOrderAddTest(), RepairOrder.class);
        assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
    }

    @When("Find the required order. Delete.")
    public void findTheRequiredOrder() {
        restTemplate.
                delete(URL + "/" + responseEntity.getBody().getRepairOrderId());
    }

    @Then("The delete 'IS SUCCESSFUL'")
    public void theDeleteIsSuccessful() {
        assertThrows(RuntimeException.class, () -> restTemplate.
                getForEntity(URL + "/" + responseEntity.getBody().getRepairOrderId(), RepairOrder.class));
    }

    @Then("But ID = {int} no in the database. The delete 'IS UNSUCCESSFUL'")
    public void butIDNoInTheDatabaseTheDeleteISUNSUCCESSFUL(int id1000) {
        assertThrows(HttpClientErrorException.class, () -> restTemplate.
                delete(URL + "/" + id1000));
    }

    private RepairOrder repairOrderAddTest() throws IOException {
        return repairOrderService
                .add(objectMapper.readValue(loadTestFile("json/newOrder.json"), RepairOrder.class));
    }
}