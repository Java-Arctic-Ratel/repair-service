package com.epam.repair.rest_app;

import com.epam.repair.dao.StreetDao;
import com.epam.repair.model.Street;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * City Service Interface implementation.
 */
@Service
@Transactional
public class StreetServiceImpl implements StreetService{

    private final StreetDao streetDao;

    public StreetServiceImpl(StreetDao streetDao) {
        this.streetDao = streetDao;
    }

    @Override
    public List<Street> findAll(){
        return streetDao.findAll();
    }
}
