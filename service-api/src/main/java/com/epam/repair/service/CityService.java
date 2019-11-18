package com.epam.repair.service;

import com.epam.repair.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * City Service Interface.
 */
public interface CityService {

    /**
     * Find all list.
     *
     * @param pageable the pageable
     * @return the list
     */
    Page<City> findAll(Pageable pageable);
}