package com.epam.repair.dao;

import com.epam.repair.model.City;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
@DataJpaTest
@TestPropertySource("classpath:application-test.properties")
public class CityDaoTest {

    public static final Integer CITY_ID_1 = 1;
    private static final String CITY_NAME_BREST = "Brest";
    private static final String CITY_NAME_ZAKOPANE = "Zakopane";

    @Autowired
    private CityDao cityDao;

    @Test
    public void findAll() {
        List<City> cities = cityDao.findAll();

        assertNotNull(cities);
        assertTrue(cities.size() > 0);
    }

    @Test
    public void findById() {
        City testCity = cityDao.findById(CITY_ID_1).get();

        assertNotNull(testCity);
        assertTrue(testCity.getCityId().equals(CITY_ID_1));
        assertTrue(testCity.getCityName().equals(CITY_NAME_BREST));
    }

    @Test
    public void save() {
        City testCity = new City();
        testCity.setCityName(CITY_NAME_ZAKOPANE);

        City addCity = cityDao.save(testCity);

        assertNotNull(addCity);
        assertEquals(addCity.getCityName(), CITY_NAME_ZAKOPANE);
    }

    @Test
    public void update() {
        City testCity = cityDao.findById(CITY_ID_1).get();

        testCity.setCityName(CITY_NAME_ZAKOPANE);
        cityDao.save(testCity);

        City updateCity = cityDao.findById(testCity.getCityId()).get();
        
        assertEquals(updateCity.getCityId(), CITY_ID_1);
        assertEquals(updateCity.getCityName(), CITY_NAME_ZAKOPANE);
    }

    @Test
    public void deleteById() {
        City testCity = new City();
        testCity.setCityName(CITY_NAME_ZAKOPANE);

        cityDao.save(testCity);
        int sizeBeforeDelete = cityDao.findAll().size();

        cityDao.deleteById(testCity.getCityId());
        int sizeAfterDelete = cityDao.findAll().size();

        assertEquals(sizeBeforeDelete - 1, sizeAfterDelete);
        assertTrue(cityDao.findById(testCity.getCityId()).isEmpty());
    }
}
