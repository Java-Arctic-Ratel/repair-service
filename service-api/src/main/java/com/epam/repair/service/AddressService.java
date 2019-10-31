package com.epam.repair.service;

import com.epam.repair.model.Address;
import java.util.List;

/**
 * Address Service Interface.
 */
public interface AddressService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<Address> findAll();
}
