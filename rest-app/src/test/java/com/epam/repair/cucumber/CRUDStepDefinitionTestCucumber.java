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
    int ORDER_ID_1000 = 1000;
    private String FIRST_NAME_MORE_40 = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
    private String FIRST_NAME_0 = "";

    private ResponseEntity<RepairOrder> responseEntity = null;

    @Autowired
    private RepairOrderService repairOrderService;

    @Autowired
    private ObjectMapper objectMapper;

//---ADD---ADD---ADD---ADD---ADD---ADD---ADD---ADD---ADD---ADD---ADD---ADD---ADD---ADD---ADD---ADD---ADD

    @Given("A new client brought a device.")
    public void a_new_customer_brought_a_device() {
    }

    @When("Add a new client and device.")
    public void add_a_new_client_and_device() throws IOException {
        responseEntity = restTemplate.
                postForEntity(URL, repairOrderAddTest(), RepairOrder.class);

        assertEquals(responseEntity.getStatusCode(), HttpStatus.CREATED);
    }

    @Then("The order is assigned a unique number.")
    public void the_order_is_assigned_a_unique_number() {

        assertNotNull(responseEntity.getBody().getRepairOrderId());
    }

    @Then("Write the client first name more than 40 characters.")
    public void writeTheCustomerFirstNameMoreThanCharacters() throws IOException {
        RepairOrder repairOrderAddValidMore40 = repairOrderAddTest();
        repairOrderAddValidMore40.getClient().setFirstName(FIRST_NAME_MORE_40);

        assertThrows(HttpClientErrorException.class, () -> restTemplate.
                postForEntity(URL, repairOrderAddValidMore40, RepairOrder.class));
    }

    @Then("Write the customer first name than 0 characters.")
    public void writeTheCustomerFirstNameThan0Characters() throws IOException {
        RepairOrder repairOrderAddValidThan0 = repairOrderAddTest();
        repairOrderAddValidThan0.getClient().setFirstName(FIRST_NAME_0);

        assertThrows(HttpClientErrorException.class, () -> restTemplate.
                postForEntity(URL, repairOrderAddValidThan0, RepairOrder.class));
    }

    @Then("Save empty body.")
    public void saveEmptyBody() throws IOException {
        assertThrows(HttpClientErrorException.class, () -> restTemplate.
                postForEntity(URL, null, RepairOrder.class));
    }

//---DELETE---DELETE---DELETE---DELETE---DELETE---DELETE---DELETE---DELETE---DELETE---DELETE

    @Given("User wants to delete order.")
    public void userWantsToDeleteOrder() {
    }

    @When("Find the required order.")
    public void findTheRequiredOrder() throws IOException {
        responseEntity = restTemplate.
                postForEntity(URL, repairOrderAddTest(), RepairOrder.class);
    }

    @Then("The delete 'IS SUCCESSFUL'")
    public void theDeleteIsSuccessful() {

        int orderDeleteId = responseEntity.getBody().getRepairOrderId();
        restTemplate.
                delete(URL + "/" + orderDeleteId);

        assertThrows(RuntimeException.class, () -> restTemplate.
                getForEntity(URL + "/" + orderDeleteId, RepairOrder.class));
    }

    @Then("But it is not in the database. The delete 'IS UNSUCCESSFUL'")
    public void theDeleteIsUnsuccessful() {
        assertThrows(HttpClientErrorException.class, () -> restTemplate.
                delete(URL + "/" + ORDER_ID_1000));
    }

//---EDIT---EDIT---EDIT---EDIT---EDIT---EDIT---EDIT---EDIT---EDIT---EDIT---EDIT---EDIT---EDIT

    @Given("Order is ready to issue.")
    public void order_is_ready_to_issue() {
    }

    @Given("User need to edit the client first name in a order.")
    public void userNeedToEditTheClientFirstNameInAOrder() {
    }

    @When("Find the order.")
    public void find_the_order() throws IOException {
        responseEntity = restTemplate.
                postForEntity(URL, repairOrderAddTest(), RepairOrder.class);

        responseEntity = restTemplate.
                getForEntity(URL + "/" + responseEntity.getBody().getRepairOrderId(), RepairOrder.class);
    }

    @Then("Change status --> {string}.")
    public void change_status_in_work(String expectedStatus) {
        responseEntity.getBody().getStatus().setStatusId(3);

        restTemplate.put(URL, responseEntity.getBody());

        responseEntity = restTemplate.
                getForEntity(URL + "/" + responseEntity.getBody().getRepairOrderId(), RepairOrder.class);

        assertEquals(responseEntity.getBody().getStatus().getStatusName(), expectedStatus);
    }

//---GET---GET---GET---GET---GET---GET---GET---GET---GET---GET---GET---GET---GET---GET---GET---GET

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

    @Then("But it is not in the database. The get by id 'IS UNSUCCESSFUL'")
    public void butItIsNotInTheDatabaseTheGetByIdISUNSUCCESSFUL() {
        assertThrows(HttpClientErrorException.class, () -> restTemplate.
                getForEntity(URL + "/" + ORDER_ID_1000, RepairOrder.class));
    }

    private RepairOrder repairOrderAddTest() throws IOException {
        return repairOrderService
                .add(objectMapper.readValue(loadTestFile("json/newOrder.json"), RepairOrder.class));
    }


}