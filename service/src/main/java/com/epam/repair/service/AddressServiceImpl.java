package com.epam.repair.service;

import com.epam.repair.dao.AddressDao;
import com.epam.repair.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public Page<Address> findAll(Pageable pageable) {
        return addressDao.findAll(pageable);
    }
}