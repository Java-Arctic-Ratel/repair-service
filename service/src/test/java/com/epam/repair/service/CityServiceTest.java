package com.epam.repair.service;

import com.epam.repair.dao.CityDao;
import com.epam.repair.model.City;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
public class CityServiceTest {

    private static final Integer CITY_ID_1 = 1;
    private static final Integer CITY_ID_2 = 2;
    private static final String CITY_NAME = "cityName-";
    private Integer PAGE_0 = 0;
    private Integer SIZE_2 = 2;

    @InjectMocks
    private CityServiceImpl cityService;

    @Mock
    private CityDao cityDao;

    @Test
    public void findAll() {
        Mockito.when(cityDao.findAll()).thenReturn(Arrays.asList(createCityForTest(CITY_ID_1),
                createCityForTest(CITY_ID_2)));
        Page<City> cities = cityService.findAll(PageRequest.of(PAGE_0, SIZE_2));

        assertNotNull(cities);
        assertTrue(cities.getContent().size() > 0);

        Mockito.verify(cityDao).findAll();
    }

    private City createCityForTest(int cityId) {
        City city = new City();
        city.setCityId(cityId);
        city.setCityName(CITY_NAME + cityId);
        return city;
    }
}