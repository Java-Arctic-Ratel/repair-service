package com.epam.repair.app.rest.controller;

import com.epam.repair.model.RepairOrder;
import com.epam.repair.model.dto.RepairOrderDTO;
import com.epam.repair.service.RepairOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

/**
 * The type Repair order controller.
 */
@Profile({"!soap", "rest"})
@RestController
@RequestMapping("/order")
public class RepairOrderController {

    @Autowired
    private RepairOrderService repairOrderService;

    /**
     * Find all page.
     *
     * @param pageable the pageable
     * @return the page
     */
    @GetMapping
    public Page<RepairOrderDTO> findAll(Pageable pageable) {
        return repairOrderService.findAll(pageable);
    }

    /**
     * Find by id repair order.
     *
     * @param repairOrderId the repair order id
     * @return the repair order
     */
    @GetMapping(value = "/{repairOrderId}")
    @ResponseStatus(value = HttpStatus.OK)
    public RepairOrder findById(@PathVariable Integer repairOrderId) {
        return repairOrderService.findById(repairOrderId);
    }

    /**
     * Add response entity.
     *
     * @param repairOrder the repair order
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<RepairOrder> add(@Valid
                                           @RequestBody RepairOrder repairOrder) {
        RepairOrder result = repairOrderService.add(repairOrder);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    /**
     * Update.
     *
     * @param repairOrder the repair order
     */
    @PutMapping
    public void update(@Valid
                       @RequestBody RepairOrder repairOrder) {
        repairOrderService.update(repairOrder);
    }

    /**
     * Delete by id.
     *
     * @param repairOrderId the repair order id
     */
    @DeleteMapping(value = "/{repairOrderId}")
    public void deleteById(@PathVariable("repairOrderId") Integer repairOrderId) {
        repairOrderService.deleteById(repairOrderId);
    }

    /**
     * Find repair order by client first name containing and client last name containing and client phone number all ignore case page.
     *
     * @param pageable          the pageable
     * @param firstName         the first name
     * @param lastName          the last name
     * @param clientPhoneNumber the client phone number
     * @param brandName         the brand name
     * @param modelName         the model name
     * @return the page
     */
    @GetMapping(value = "/filter1")
    public Page<RepairOrderDTO> findRepairOrderByClient_FirstNameContainingAndClient_LastNameContainingAndClient_clientPhoneNumberContainingAndDevice_BrandContainingAndDevice_ModelContainingAllIgnoreCase(Pageable pageable,
                                                                                                                                                                                                            @RequestParam(value = "firstName") String firstName,
                                                                                                                                                                                                            @RequestParam(value = "lastName") String lastName,
                                                                                                                                                                                                            @RequestParam(value = "clientPhoneNumber") String clientPhoneNumber,
                                                                                                                                                                                                            @RequestParam(value = "brandName") String brandName,
                                                                                                                                                                                                            @RequestParam(value = "modelName") String modelName) {
        return repairOrderService.findRepairOrderByClient_FirstNameContainingAndClient_LastNameContainingAndClient_clientPhoneNumberContainingAndDevice_BrandContainingAndDevice_ModelContainingAllIgnoreCase(pageable, firstName, lastName,
                clientPhoneNumber, brandName, modelName);
    }

    /**
     * Find by repair order start date between page.
     *
     * @param pageable  the pageable
     * @param startDate the start date
     * @param endDate   the end date
     * @return the page
     */
    @GetMapping(value = "/filter2")
    public Page<RepairOrderDTO> findByRepairOrderStartDateBetween(Pageable pageable,
                                                                  @RequestParam(value = "startDate") LocalDate startDate,
                                                                  @RequestParam(value = "endDate") LocalDate endDate) {
        return repairOrderService.findByRepairOrderStartDateBetween(pageable, startDate, endDate);
    }

    /**
     * Find repair order by client first name containing and client last name containing and client client phone number containing and device brand containing and device model containing and repair order start date between all ignore case page.
     *
     * @param pageable          the pageable
     * @param firstName         the first name
     * @param lastName          the last name
     * @param clientPhoneNumber the client phone number
     * @param brandName         the brand name
     * @param modelName         the model name
     * @param startDate         the start date
     * @param endDate           the end date
     * @return the page
     */
    @GetMapping(value = "/filter3")
    public Page<RepairOrderDTO> findRepairOrderByClient_FirstNameContainingAndClient_LastNameContainingAndClient_clientPhoneNumberContainingAndDevice_BrandContainingAndDevice_ModelContainingAndRepairOrderStartDateBetweenAllIgnoreCase(Pageable pageable,
                                                                                                                                                                                                                                          @RequestParam(value = "firstName") String firstName,
                                                                                                                                                                                                                                          @RequestParam(value = "lastName") String lastName,
                                                                                                                                                                                                                                          @RequestParam(value = "clientPhoneNumber") String clientPhoneNumber,
                                                                                                                                                                                                                                          @RequestParam(value = "brandName") String brandName,
                                                                                                                                                                                                                                          @RequestParam(value = "modelName") String modelName,
                                                                                                                                                                                                                                          @RequestParam(value = "startDate") LocalDate startDate,
                                                                                                                                                                                                                                          @RequestParam(value = "endDate") LocalDate endDate) {
        return repairOrderService.findRepairOrderByClient_FirstNameContainingAndClient_LastNameContainingAndClient_clientPhoneNumberContainingAndDevice_BrandContainingAndDevice_ModelContainingAndRepairOrderStartDateBetweenAllIgnoreCase(
                pageable, firstName, lastName, clientPhoneNumber, brandName, modelName, startDate, endDate);
    }

    /**
     * Filter by first name or last name or phone number or brand or model page.
     *
     * @param pageable          the pageable
     * @param firstName         the first name
     * @param lastName          the last name
     * @param clientPhoneNumber the client phone number
     * @param brandName         the brand name
     * @param modelName         the model name
     * @return the page
     */
    @GetMapping(value = "/filter4")
    public Page<RepairOrderDTO> filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelJPQL(Pageable pageable,
                                                                                               @RequestParam(value = "firstName") String firstName,
                                                                                               @RequestParam(value = "lastName") String lastName,
                                                                                               @RequestParam(value = "clientPhoneNumber") String clientPhoneNumber,
                                                                                               @RequestParam(value = "brandName") String brandName,
                                                                                               @RequestParam(value = "modelName") String modelName) {
        return repairOrderService.filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelJPQL(pageable, firstName, lastName, clientPhoneNumber, brandName, modelName);
    }

    /**
     * Filter by start date page.
     *
     * @param pageable  the pageable
     * @param startDate the start date
     * @param endDate   the end date
     * @return the page
     */
    @GetMapping(value = "/filter5")
    public Page<RepairOrderDTO> filterByStartDateJPQL(Pageable pageable,
                                                      @RequestParam(value = "startDate") LocalDate startDate,
                                                      @RequestParam(value = "endDate") LocalDate endDate) {
        return repairOrderService.filterByStartDateJPQL(pageable, startDate, endDate);
    }

    /**
     * Filter by first name and last name and phone number and brand and model and date page.
     *
     * @param pageable          the pageable
     * @param firstName         the first name
     * @param lastName          the last name
     * @param clientPhoneNumber the client phone number
     * @param brandName         the brand name
     * @param modelName         the model name
     * @param startDate         the start date
     * @param endDate           the end date
     * @return the page
     */
    @GetMapping(value = "/filter6")
    public Page<RepairOrderDTO> filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelAndDateJPQL(Pageable pageable,
                                                                                                      @RequestParam(value = "firstName") String firstName,
                                                                                                      @RequestParam(value = "lastName") String lastName,
                                                                                                      @RequestParam(value = "clientPhoneNumber") String clientPhoneNumber,
                                                                                                      @RequestParam(value = "brandName") String brandName,
                                                                                                      @RequestParam(value = "modelName") String modelName,
                                                                                                      @RequestParam(value = "startDate") LocalDate startDate,
                                                                                                      @RequestParam(value = "endDate") LocalDate endDate) {
        return repairOrderService.filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelAndDateJPQL(pageable, firstName,
                lastName, clientPhoneNumber, brandName, modelName, startDate, endDate);
    }

    /**
     * Filter by first name and last name and phone number and brand and model 1 page.
     *
     * @param pageable          the pageable
     * @param firstName         the first name
     * @param lastName          the last name
     * @param clientPhoneNumber the client phone number
     * @param brandName         the brand name
     * @param modelName         the model name
     * @return the page
     */
    @GetMapping(value = "/filter7")
    public Page<RepairOrderDTO> filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModel(Pageable pageable,
                                                                                           @RequestParam(value = "firstName") String firstName,
                                                                                           @RequestParam(value = "lastName") String lastName,
                                                                                           @RequestParam(value = "clientPhoneNumber") String clientPhoneNumber,
                                                                                           @RequestParam(value = "brandName") String brandName,
                                                                                           @RequestParam(value = "modelName") String modelName) {
        return repairOrderService.filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModel(pageable, firstName, lastName,
                clientPhoneNumber, brandName, modelName);
    }

    /**
     * Filter by start date 1 page.
     *
     * @param pageable  the pageable
     * @param startDate the start date
     * @param endDate   the end date
     * @return the page
     */
    @GetMapping(value = "/filter8")
    public Page<RepairOrderDTO> filterByStartDate(Pageable pageable,
                                                  @RequestParam(value = "startDate") LocalDate startDate,
                                                  @RequestParam(value = "endDate") LocalDate endDate) {
        return repairOrderService.filterByStartDate(pageable, startDate, endDate);
    }

    /**
     * Filter by first name and last name and phone number and brand and model and date 1 page.
     *
     * @param pageable          the pageable
     * @param firstName         the first name
     * @param lastName          the last name
     * @param clientPhoneNumber the client phone number
     * @param brandName         the brand name
     * @param modelName         the model name
     * @param startDate         the start date
     * @param endDate           the end date
     * @return the page
     */
    @GetMapping(value = "/filter9")
    public Page<RepairOrderDTO> filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelAndDate(Pageable pageable,
                                                                                                  @RequestParam(value = "firstName") String firstName,
                                                                                                  @RequestParam(value = "lastName") String lastName,
                                                                                                  @RequestParam(value = "clientPhoneNumber") String clientPhoneNumber,
                                                                                                  @RequestParam(value = "brandName") String brandName,
                                                                                                  @RequestParam(value = "modelName") String modelName,
                                                                                                  @RequestParam(value = "startDate") LocalDate startDate,
                                                                                                  @RequestParam(value = "endDate") LocalDate endDate) {
        return repairOrderService.filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelAndDate(pageable, firstName,
                lastName, clientPhoneNumber, brandName, modelName, startDate, endDate);
    }
}
