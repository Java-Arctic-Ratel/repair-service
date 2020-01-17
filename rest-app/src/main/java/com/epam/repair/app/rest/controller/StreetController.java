package com.epam.repair.app.rest.controller;

import com.epam.repair.model.Street;
import com.epam.repair.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Profile({"rest"})
@RequestMapping("/street")
public class StreetController {

    @Autowired
    private StreetService streetService;

    @GetMapping
    public List<Street> findAll() {
        return streetService.findAll();
    }
}
