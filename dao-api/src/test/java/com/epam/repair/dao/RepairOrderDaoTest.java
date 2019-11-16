package com.epam.repair.dao;

import com.epam.repair.model.RepairOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static com.epam.repair.utils.TestUtils.loadTestFile;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
class RepairOrderDaoTest {

    public static final Integer Order_ID_1 = 1;

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
        LocalDate orderStartDate = LocalDate.of(2020, 10, 20);
        LocalDate orderEndDate = LocalDate.of(2030, 10, 30);
        LocalDate orderIssueDate = LocalDate.of(2030, 10, 25);

        RepairOrder newRepairOrder = objectMapper.readValue(loadTestFile("json/order.json"), RepairOrder.class);
        newRepairOrder.setRepairOrderStartDate(orderStartDate);
        newRepairOrder.setRepairOrderEndDate(orderEndDate);
        newRepairOrder.setRepairOrderIssueDate(orderIssueDate);
        RepairOrder addRepairOrder = repairOrderDao.save(newRepairOrder);

        assertNotNull(addRepairOrder);
        assertEquals(newRepairOrder, addRepairOrder);
    }

    @Test
    public void update() throws IOException {
        LocalDate orderStartDate = LocalDate.of(2020, 10, 20);
        LocalDate orderEndDate = LocalDate.of(2030, 10, 30);
        LocalDate orderIssueDate = LocalDate.of(2030, 10, 25);

        RepairOrder testRepairOrder = repairOrderDao.findById(Order_ID_1).get();

        RepairOrder newRepairOrder = objectMapper.readValue(loadTestFile("json/order.json"), RepairOrder.class);

        testRepairOrder.setRepairOrderStartDate(orderStartDate);
        testRepairOrder.setRepairOrderEndDate(orderEndDate);
        testRepairOrder.setRepairOrderIssueDate(orderIssueDate);

        testRepairOrder.setClient(newRepairOrder.getClient());
        testRepairOrder.setDevice(newRepairOrder.getDevice());
        testRepairOrder.setEmployee(newRepairOrder.getEmployee());
        testRepairOrder.setSparePart(newRepairOrder.getSparePart());
        testRepairOrder.setStatus(newRepairOrder.getStatus());

        assertEquals(repairOrderDao.save(testRepairOrder), testRepairOrder);
    }

    @Test
    public void deleteById() throws IOException {
        LocalDate orderStartDate = LocalDate.of(2020, 10, 20);
        LocalDate orderEndDate = LocalDate.of(2030, 10, 30);
        LocalDate orderIssueDate = LocalDate.of(2030, 10, 25);

        RepairOrder newRepairOrder = objectMapper.readValue(loadTestFile("json/order.json"), RepairOrder.class);
        newRepairOrder.setRepairOrderStartDate(orderStartDate);
        newRepairOrder.setRepairOrderEndDate(orderEndDate);
        newRepairOrder.setRepairOrderIssueDate(orderIssueDate);

        repairOrderDao.save(newRepairOrder);
        int sizeBeforeDelete = repairOrderDao.findAll().size();

        repairOrderDao.deleteById(newRepairOrder.getRepairOrderId());
        int sizeAfterDelete = repairOrderDao.findAll().size();

        assertEquals(sizeBeforeDelete - 1, sizeAfterDelete);
        assertTrue(repairOrderDao.findById(newRepairOrder.getRepairOrderId()).isEmpty());
    }
}
