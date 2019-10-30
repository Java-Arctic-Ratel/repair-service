package com.epam.repair.rest.controller;

import com.epam.repair.model.Address;
import com.epam.repair.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressRestController {

    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/address")
    public List<Address> findAll() {
        return addressService.findAll();
    }

}