package com.epam.repair.service;

import com.epam.repair.dao.CityDao;
import com.epam.repair.model.City;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * City Service Interface implementation.
 */
@Service
@Transactional
public class CityServiceImpl implements CityService {

    private final CityDao cityDao;

    public CityServiceImpl(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public List<City> findAll(){
        return cityDao.findAll();
    }
}
