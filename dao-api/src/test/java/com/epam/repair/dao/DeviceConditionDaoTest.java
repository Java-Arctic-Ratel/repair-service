package com.epam.repair.dao;

import com.epam.repair.model.Defect;
import com.epam.repair.model.DeviceCondition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
class DeviceConditionDaoTest {

    @Autowired
    private DeviceConditionDao deviceConditionDao;

    @Test
    public void findAll() {
        List<DeviceCondition> deviceConditions = deviceConditionDao.findAll();

        assertNotNull(deviceConditions);
        assertTrue(deviceConditions.size() > 0);
    }
}
