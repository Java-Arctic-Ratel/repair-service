package com.epam.repair.dao;

import com.epam.repair.config.TestConfig;
import com.epam.repair.model.RepairOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static com.epam.repair.utils.TestUtils.loadTestFile;
import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = TestConfig.class)
@DataJpaTest
@EnableAutoConfiguration
@TestPropertySource("classpath:application-test.properties")
class RepairOrderDaoTest {
    public static final Integer Order_ID_1 = 1;
    private Integer PAGE_0 = 0;
    private Integer SIZE_2 = 2;
    private LocalDate START_DATE = LocalDate.of(2019, 10, 10);
    private LocalDate END_DATE = LocalDate.of(2019, 10, 13);
    private LocalDate ISSUE_DATE = LocalDate.of(2019, 10, 13);

    @Autowired
    private RepairOrderDao repairOrderDao;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void findAll() {
        List<RepairOrder> repairOrders = repairOrderDao.findAll();

        assertNotNull(repairOrders);
        assertTrue(repairOrders.size() > 0);
    }

    @Test
    public void findById() {
        RepairOrder testRepairOrder = repairOrderDao.findById(Order_ID_1).get();

        assertNotNull(testRepairOrder);
        assertTrue(testRepairOrder.getRepairOrderId().equals(Order_ID_1));
    }

    @Test
    public void save() throws IOException {
        RepairOrder newRepairOrder = objectMapper.readValue(loadTestFile("json/order.json"), RepairOrder.class);
        newRepairOrder.setRepairOrderStartDate(START_DATE);
        newRepairOrder.setRepairOrderEndDate(END_DATE);
        newRepairOrder.setRepairOrderIssueDate(ISSUE_DATE);
        RepairOrder addRepairOrder = repairOrderDao.save(newRepairOrder);

        assertNotNull(addRepairOrder);
        assertEquals(newRepairOrder, addRepairOrder);
    }

    @Test
    public void update() throws IOException {
        RepairOrder testRepairOrder = repairOrderDao.findById(Order_ID_1).get();

        RepairOrder newRepairOrder = objectMapper.readValue(loadTestFile("json/order.json"), RepairOrder.class);

        testRepairOrder.setRepairOrderStartDate(START_DATE);
        testRepairOrder.setRepairOrderEndDate(END_DATE);
        testRepairOrder.setRepairOrderIssueDate(ISSUE_DATE);

        testRepairOrder.setClient(newRepairOrder.getClient());
        testRepairOrder.setDevice(newRepairOrder.getDevice());
        testRepairOrder.setEmployee(newRepairOrder.getEmployee());
        testRepairOrder.setSparePart(newRepairOrder.getSparePart());
        testRepairOrder.setStatus(newRepairOrder.getStatus());

        assertEquals(repairOrderDao.save(testRepairOrder), testRepairOrder);
    }

    @Test
    public void deleteById() throws IOException {
        RepairOrder newRepairOrder = objectMapper.readValue(loadTestFile("json/order.json"), RepairOrder.class);
        newRepairOrder.setRepairOrderStartDate(START_DATE);
        newRepairOrder.setRepairOrderEndDate(END_DATE);
        newRepairOrder.setRepairOrderIssueDate(ISSUE_DATE);

        repairOrderDao.save(newRepairOrder);
        int sizeBeforeDelete = repairOrderDao.findAll().size();

        repairOrderDao.deleteById(newRepairOrder.getRepairOrderId());
        int sizeAfterDelete = repairOrderDao.findAll().size();

        assertEquals(sizeBeforeDelete - 1, sizeAfterDelete);
        assertTrue(repairOrderDao.findById(newRepairOrder.getRepairOrderId()).isEmpty());
    }

    @Test
    public void findRepairOrderByClient_FirstNameContainingAndClient_LastNameContainingAndClient_clientPhoneNumberContainingAndDevice_BrandContainingAndDevice_ModelContainingAllIgnoreCase() {
        Page<RepairOrder> repairOrders = repairOrderDao
                .findRepairOrderByClient_FirstNameContainingAndClient_LastNameContainingAndClient_clientPhoneNumberContainingAndDevice_BrandContainingAndDevice_ModelContainingAllIgnoreCase(
                        PageRequest.of(0, 2), "", "", "723", "", "");

        assertTrue(repairOrders.getContent().size() > 0);

    }

    @Test
    public void findByRepairOrderStartDateBetween() {
        Page<RepairOrder> repairOrders = repairOrderDao.findByRepairOrderStartDateBetween(PageRequest.of(PAGE_0, SIZE_2), START_DATE, END_DATE);

        assertTrue(repairOrders.getContent().size() > 0);
    }


    @Test
    public void findRepairOrderByClient_FirstNameContainingAndClient_LastNameContainingAndClient_clientPhoneNumberContainingAndDevice_BrandContainingAndDevice_ModelContainingAndRepairOrderStartDateBetweenAllIgnoreCase() {
        Page<RepairOrder> repairOrders = repairOrderDao
                .findRepairOrderByClient_FirstNameContainingAndClient_LastNameContainingAndClient_clientPhoneNumberContainingAndDevice_BrandContainingAndDevice_ModelContainingAndRepairOrderStartDateBetweenAllIgnoreCase(
                        PageRequest.of(0, 2), "2", "2", "723", "", "", START_DATE, END_DATE);

        assertTrue(repairOrders.getContent().size() > 0);
    }

    @Test
    public void filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelJPQL() {
        Page<RepairOrder> repairOrders = repairOrderDao.
                filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelJPQL(PageRequest.of(PAGE_0, SIZE_2),
                        "", "", null, "AW", "p");
        assertTrue(repairOrders.getContent().size() > 0);
    }

    @Test
    public void filterByStartDateJPQL() {
        Page<RepairOrder> repairOrders = repairOrderDao.filterByStartDateJPQL(PageRequest.of(PAGE_0, SIZE_2), null, END_DATE);

        assertTrue(repairOrders.getContent().size() > 0);
    }

    @Test
    public void filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelAndDateJPQL() {
        Page<RepairOrder> repairOrders = repairOrderDao.
                filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelAndDateJPQL(PageRequest.of(PAGE_0, SIZE_2),
                        null, "", "", "", "", START_DATE, null);
        assertTrue(repairOrders.getContent().size() > 0);
    }

    @Test
    public void filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModel() {
        Page<RepairOrder> repairOrders = repairOrderDao.filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModel(PageRequest.of(PAGE_0, SIZE_2),
                "1", "", "0", null, "p");
        assertTrue(repairOrders.getContent().size() > 0);
    }

    @Test
    public void filterByStartDate() {
        Page<RepairOrder> repairOrders = repairOrderDao.filterByStartDate(PageRequest.of(PAGE_0, SIZE_2), null, END_DATE);

        assertTrue(repairOrders.getContent().size() > 0);
    }

    @Test
    public void filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelAndDate() {
        Page<RepairOrder> repairOrders = repairOrderDao.filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelAndDate(PageRequest.of(PAGE_0, SIZE_2),
                "1", "", "0", null, "p", START_DATE, null);
        assertTrue(repairOrders.getContent().size() > 0);
    }
}