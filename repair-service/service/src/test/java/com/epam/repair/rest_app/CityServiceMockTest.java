package com.epam.repair.rest_app;

import com.epam.repair.dao.CityDao;
import com.epam.repair.model.City;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
public class CityServiceMockTest {

    private static final Integer CITY_ID_1 = 1;
    private static final Integer CITY_ID_2 = 2;
    private static final String CITY_NAME = "cityName-";

    @InjectMocks
    private CityServiceImpl cityService;

    @Mock
    private CityDao cityDao;

    @Test
    public void findAll() {
        Mockito.when(cityDao.findAll()).thenReturn(Arrays.asList(createCityForTest(CITY_ID_1), createCityForTest(CITY_ID_2)));
        List<City> cities = cityService.findAll();

        assertNotNull(cities);
        assertTrue(cities.size() > 0);
        assertTrue(cities.size() == 2);

        Mockito.verify(cityDao).findAll();
    }

    private City createCityForTest(int cityId) {

        City city = new City();
        city.setCityId(cityId);
        city.setCityName(CITY_NAME + cityId);
        return city;
    }
}
