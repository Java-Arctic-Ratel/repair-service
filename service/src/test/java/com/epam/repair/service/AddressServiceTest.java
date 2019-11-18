package com.epam.repair.service;

import com.epam.repair.dao.AddressDao;
import com.epam.repair.model.Address;
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
public class AddressServiceTest {

    private static final Integer ADDRESS_ID_1 = 1;
    private static final Integer ADDRESS_ID_2 = 2;
    private Integer PAGE_0 = 0;
    private Integer SIZE_2 = 2;

    @InjectMocks
    private AddressServiceImpl addressService;

    @Mock
    private AddressDao addressDao;

    @Test
    public void findAll() {
        Mockito.when(addressDao.findAll()).thenReturn(Arrays.asList(createAddressForTest(ADDRESS_ID_1),
                createAddressForTest(ADDRESS_ID_2)));
        Page<Address> addresses = addressService.findAll(PageRequest.of(PAGE_0, SIZE_2));

        assertNotNull(addresses);
        assertTrue(addresses.getContent().size() > 0);

        Mockito.verify(addressDao).findAll();
    }

    private Address createAddressForTest(int addressId) {
        Address address = new Address();
        address.setAddressId(addressId);
        address.setHouseNumber("" + addressId);
        address.setApartmentNumber("" + addressId);
        return address;
    }
}