package com.epam.repair.service;

import com.epam.repair.model.City;

import java.util.List;

/**
 * City Service Interface.
 */
public interface CityService {

    /**
     * Find all list.
     *
     * @return the list
     */
    List<City> findAll();
}
