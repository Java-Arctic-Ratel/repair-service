package com.epam.repair.service;

import com.epam.repair.dao.StreetDao;
import com.epam.repair.model.Street;
import com.epam.repair.service.StreetServiceImpl;
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
public class StreetServiceTest {

    private static final Integer STREET_ID_1 = 1;
    private static final Integer STREET_ID_2 = 2;
    private static final String STREET_NAME = "streetName-";

    @InjectMocks
    private StreetServiceImpl streetService;

    @Mock
    private StreetDao streetDao;

    @Test
    public void findAll() {
        Mockito.when(streetDao.findAll()).thenReturn(Arrays.asList(createStreetForTest(STREET_ID_1), createStreetForTest(STREET_ID_2)));
        List<Street> streets = streetService.findAll();

        assertNotNull(streets);
        assertTrue(streets.size() > 0);

        Mockito.verify(streetDao).findAll();
    }

    private Street createStreetForTest(int streetId) {
        Street street = new Street();
        street.setStreetId(streetId);
        street.setStreetName(STREET_NAME + streetId);
        return street;
    }
}
