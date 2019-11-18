package com.epam.repair.rest.controller;

import com.epam.repair.model.Street;
import com.epam.repair.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class StreetController {

    @Autowired
    private StreetService streetService;

    @GetMapping(value = "/street")
    public List<Street> findAll() {
        return streetService.findAll();
    }
}