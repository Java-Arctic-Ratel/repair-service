package com.epam.repair.service;

import com.epam.repair.model.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Address Service Interface.
 */
public interface AddressService {

    /**
     * Find all list.
     *
     * @param pageable the pageable
     * @return the list
     */
    Page<Address> findAll(Pageable pageable);
}