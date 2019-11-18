package com.epam.repair.rest.controller;

import com.epam.repair.model.Address;
import com.epam.repair.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/address")
    public Page<Address> findAll(Pageable pageable) {
        return addressService.findAll(pageable);
    }
}