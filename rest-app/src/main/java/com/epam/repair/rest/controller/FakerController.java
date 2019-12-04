package com.epam.repair.rest.controller;

import com.epam.repair.service.DataFakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Java faker controller.
 */
@RestController
@RequestMapping("/faker")
public class FakerController {

    @Autowired
    private DataFakerService dataFakerService;

    /**
     * Create fake data.
     *
     * @param numberOfRepairOrders - quantity of necessary orders
     * @return the String
     */
    @GetMapping(value = "/{numberOfRepairOrders}")
    @ResponseStatus(value = HttpStatus.OK)
    public String fillDataBase(@PathVariable Integer numberOfRepairOrders) {
        dataFakerService.startCreation(numberOfRepairOrders);
        return "Filling DataBase is complete";
    }
}
