package com.epam.repair.dao;

import com.epam.repair.app.config.TestConfig;
import com.epam.repair.model.Street;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ContextConfiguration(classes = TestConfig.class)
@DataJpaTest
@EnableAutoConfiguration
@TestPropertySource("classpath:application-test.properties")
class StreetDaoTest {

    @Autowired
    private StreetDao streetDao;

    @Test
    public void findAll() {
        List<Street> streets = streetDao.findAll();

        assertNotNull(streets);
        assertTrue(streets.size() > 0);
    }
}
