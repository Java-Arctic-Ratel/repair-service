package com.epam.repair.rest_app.controller;


import com.epam.repair.model.City;
import com.epam.repair.rest_app.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CityRestController {

    @Autowired
    private CityService cityService;

    @GetMapping(value = "/city")
    public List<City> findAll() {
        return cityService.findAll();
    }

}