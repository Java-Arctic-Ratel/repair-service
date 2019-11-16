package com.epam.repair.rest.controller;

import com.epam.repair.model.RepairOrder;
import com.epam.repair.model.dto.RepairOrderDTO;
import com.epam.repair.service.RepairOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RepairOrderController {

    @Autowired
    private RepairOrderService repairOrderService;

    @GetMapping(value = "/order")
    public List<RepairOrderDTO> findAll() {
        return repairOrderService.findAll();
    }

    @GetMapping(value = "/order/{repairOrderId}")
    @ResponseStatus(value = HttpStatus.OK)
    public RepairOrder findById(@PathVariable Integer repairOrderId) {
        return repairOrderService.findById(repairOrderId);
    }

    @PostMapping(value = "/order")
    public ResponseEntity<RepairOrder> add(@RequestBody RepairOrder repairOrder) {
        RepairOrder result = repairOrderService.add(repairOrder);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @PutMapping(value = "/order")
    public void update(@RequestBody RepairOrder repairOrder) {
        repairOrderService.update(repairOrder);
    }

    @DeleteMapping(value = "/order/{repairOrderId}")
    public void deleteById(@PathVariable("repairOrderId") Integer repairOrderId) {
        repairOrderService.deleteById(repairOrderId);
    }
}