package com.epam.repair.dao;

import com.epam.repair.config.TestConfig;
import com.epam.repair.model.Brand;
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
class BrandDaoTest {

    @Autowired
    private BrandDao brandDao;

    @Test
    public void findAll() {
        List<Brand> brands = brandDao.findAll();

        assertNotNull(brands);
        assertTrue(brands.size() > 0);
    }
}
