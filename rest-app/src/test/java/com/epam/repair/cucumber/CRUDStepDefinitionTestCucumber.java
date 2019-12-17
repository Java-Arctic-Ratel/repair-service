package com.epam.repair.cucumber;

import com.epam.repair.config.AbstractCucumberSpringConfigurationTest;
import com.epam.repair.model.RepairOrder;
import com.epam.repair.service.RepairOrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;

import static com.epam.repair.utils.TestUtils.loadTestFile;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CRUDStepDefinitionTestCucumber extends AbstractCucumberSpringConfigurationTest {
    private ResponseEntity<RepairOrder> responseEntity = null;

    @Autowired
    private RepairOrderService repairOrderService;

    @Autowired
    private ObjectMapper objectMapper;

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
    }

    @Then("Write the client first name {string}.")
    public void writeTheCustomerFirstNameMore40(String FirstNameMore40) throws IOException {
        RepairOrder repairOrderAddValidMore40 = repairOrderAddTest();
        repairOrderAddValidMore40.getClient().setFirstName(FirstNameMore40);

        assertThrows(HttpClientErrorException.class, () -> restTemplate.
                postForEntity(URL, repairOrderAddValidMore40, RepairOrder.class));
    }

    @Then("Write the customer first name {string}.")
    public void writeTheCustomerFirstName0(String FirstName0) throws IOException {
        RepairOrder repairOrderAddValidThan0 = repairOrderAddTest();
        repairOrderAddValidThan0.getClient().setFirstName(FirstName0);

        assertThrows(HttpClientErrorException.class, () -> restTemplate.
                postForEntity(URL, repairOrderAddValidThan0, RepairOrder.class));
    }

    @Then("Save empty body - null.")
    public void saveEmptyBodyNull() {
        assertThrows(HttpClientErrorException.class, () -> restTemplate.
                postForEntity(URL, null, RepairOrder.class));
    }

    @Given("User wants to delete order.")
    public void userWantsToDeleteOrder() throws IOException {
        responseEntity = restTemplate.
                postForEntity(URL, repairOrderAddTest(), RepairOrder.class);
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

    @Given("Order is ready to issue.")
    public void orderIsReadyToIssue() throws IOException {
        responseEntity = restTemplate.
                postForEntity(URL, repairOrderAddTest(), RepairOrder.class);
    }

    @Given("User need to edit the client first name in a order.")
    public void userNeedToEditTheClientFirstNameInAOrder() throws IOException {
        responseEntity = restTemplate.
                postForEntity(URL, repairOrderAddTest(), RepairOrder.class);
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
    }

    @Given("User wants to get order")
    public void userWantsToGetOrder() throws IOException {
        responseEntity = restTemplate.
                postForEntity(URL, repairOrderAddTest(), RepairOrder.class);

    }

    @Then("The get by id 'IS SUCCESSFUL'")
    public void theGetByIdIsSuccessful() {
        int addOrderId = responseEntity.getBody().getRepairOrderId();
        responseEntity = restTemplate.
                getForEntity(URL + "/" + addOrderId, RepairOrder.class);
        int getById = responseEntity.getBody().getRepairOrderId();

        assertEquals(addOrderId, getById);
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