package com.epam.repair.rest.controller;

import com.epam.repair.model.City;
import com.epam.repair.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping(value = "/city")
    public Page<City> findAll(Pageable pageable) {
        return cityService.findAll(pageable);
    }
}