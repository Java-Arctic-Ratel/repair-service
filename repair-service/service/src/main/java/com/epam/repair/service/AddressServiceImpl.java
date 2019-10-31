package com.epam.repair.service;

import com.epam.repair.dao.AddressDao;
import com.epam.repair.model.Address;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Address Service Interface implementation.
 */
@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    private final AddressDao addressDao;

    public AddressServiceImpl(AddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public List<Address> findAll(){
        return addressDao.findAll();
    }
}
