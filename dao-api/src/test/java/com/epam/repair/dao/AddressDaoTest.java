package com.epam.repair.dao;

import com.epam.repair.app.config.TestConfig;
import com.epam.repair.model.Address;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

import java.io.IOException;
import java.util.List;

import static com.epam.repair.app.utils.TestUtils.loadTestFile;
import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = TestConfig.class)
@DataJpaTest
@EnableAutoConfiguration
@TestPropertySource("classpath:application-test.properties")
class AddressDaoTest {

    public static final Integer ADDRESS_ID_1 = 1;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void findAll() {
        List<Address> addresses = addressDao.findAll();

        assertNotNull(addresses);
        assertTrue(addresses.size() > 0);
    }

    @Test
    public void findById() {
        Address testAddress = addressDao.findById(ADDRESS_ID_1).get();

        assertNotNull(testAddress);
        assertTrue(testAddress.getAddressId().equals(ADDRESS_ID_1));
    }

    @Test
    public void save() throws IOException {
        Address newAddress = objectMapper.readValue(loadTestFile("json/address.json"), Address.class);
        Address addAddress = addressDao.save(newAddress);

        assertNotNull(addAddress);
        assertEquals(newAddress, addAddress);
    }

    @Test
    public void update() throws IOException {
        Address testAddress = addressDao.findById(ADDRESS_ID_1).get();

        Address newAddress = objectMapper.readValue(loadTestFile("json/address.json"), Address.class);

        testAddress.setApartmentNumber(newAddress.getApartmentNumber());
        testAddress.setHouseNumber(newAddress.getHouseNumber());
        testAddress.setStreet(newAddress.getStreet());
        testAddress.setCity(newAddress.getCity());

        assertEquals(addressDao.save(testAddress), testAddress);
    }

    @Test
    public void deleteById() throws IOException {
        Address newAddress = objectMapper.readValue(loadTestFile("json/address.json"), Address.class);

        addressDao.save(newAddress);
        int sizeBeforeDelete = addressDao.findAll().size();

        addressDao.deleteById(newAddress.getAddressId());
        int sizeAfterDelete = addressDao.findAll().size();

        assertEquals(sizeBeforeDelete - 1, sizeAfterDelete);
        assertTrue(addressDao.findById(newAddress.getAddressId()).isEmpty());
    }
}
