package com.epam.repair.rest.controller;

import com.epam.repair.model.City;
import com.epam.repair.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping(value = "/city")
    public List<City> findAll() {
        return cityService.findAll();
    }

}