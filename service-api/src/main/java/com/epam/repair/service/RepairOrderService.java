package com.epam.repair.service;

import com.epam.repair.model.RepairOrder;
import com.epam.repair.model.dto.RepairOrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

/**
 * The interface Repair order service.
 */
public interface RepairOrderService {

    /**
     * Find all page.
     *
     * @param pageable the pageable
     * @return the page
     */
    Page<RepairOrderDTO> findAll(Pageable pageable);

    /**
     * Find by id repair order.
     *
     * @param repairOrderId the repair order id
     * @return the repair order
     */
    RepairOrder findById(Integer repairOrderId);

    /**
     * Add repair order.
     *
     * @param repairOrder the repair order
     * @return the repair order
     */
    RepairOrder add(RepairOrder repairOrder);

    /**
     * Update repair order.
     *
     * @param repairOrder the repair order
     * @return the repair order
     */
    RepairOrder update(RepairOrder repairOrder);

    /**
     * Delete by id.
     *
     * @param repairOrderId the repair order id
     */
    void deleteById(Integer repairOrderId);

    /**
     * Find repair order by client first name containing and client last name containing and client client phone number containing and device brand containing and device model containing all ignore case page.
     *
     * @param pageable          the pageable
     * @param firstName         the first name
     * @param lastName          the last name
     * @param clientPhoneNumber the client phone number
     * @param brandName         the brand name
     * @param modelName         the model name
     * @return the page
     */
    Page<RepairOrderDTO> findRepairOrderByClient_FirstNameContainingAndClient_LastNameContainingAndClient_clientPhoneNumberContainingAndDevice_BrandContainingAndDevice_ModelContainingAllIgnoreCase(Pageable pageable,
                                                                                                                                                                                                     String firstName,
                                                                                                                                                                                                     String lastName,
                                                                                                                                                                                                     String clientPhoneNumber,
                                                                                                                                                                                                     String brandName,
                                                                                                                                                                                                     String modelName);

    /**
     * Find by repair order start date between page.
     *
     * @param pageable  the pageable
     * @param startDate the start date
     * @param endDate   the end date
     * @return the page
     */
    Page<RepairOrderDTO> findByRepairOrderStartDateBetween(Pageable pageable, LocalDate startDate, LocalDate endDate);

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
    Page<RepairOrderDTO> findRepairOrderByClient_FirstNameContainingAndClient_LastNameContainingAndClient_clientPhoneNumberContainingAndDevice_BrandContainingAndDevice_ModelContainingAndRepairOrderStartDateBetweenAllIgnoreCase(Pageable pageable,
                                                                                                                                                                                                                                   String firstName,
                                                                                                                                                                                                                                   String lastName,
                                                                                                                                                                                                                                   String clientPhoneNumber,
                                                                                                                                                                                                                                   String brandName,
                                                                                                                                                                                                                                   String modelName,
                                                                                                                                                                                                                                   LocalDate startDate,
                                                                                                                                                                                                                                   LocalDate endDate);

    /**
     * Filter by first name and last name and phone number and brand and model jpql page.
     *
     * @param pageable          the pageable
     * @param firstName         the first name
     * @param lastName          the last name
     * @param clientPhoneNumber the client phone number
     * @param brandName         the brand name
     * @param modelName         the model name
     * @return the page
     */
    Page<RepairOrderDTO> filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelJPQL(Pageable pageable, String firstName,
                                                                                        String lastName, String clientPhoneNumber,
                                                                                        String brandName, String modelName);

    /**
     * Filter by start date jpql page.
     *
     * @param pageable  the pageable
     * @param startDate the start date
     * @param endDate   the end date
     * @return the page
     */
    Page<RepairOrderDTO> filterByStartDateJPQL(Pageable pageable, LocalDate startDate, LocalDate endDate);

    /**
     * Filter by first name and last name and phone number and brand and model and date jpql page.
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
    Page<RepairOrderDTO> filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelAndDateJPQL(Pageable pageable, String firstName,
                                                                                               String lastName, String clientPhoneNumber,
                                                                                               String brandName, String modelName,
                                                                                               LocalDate startDate, LocalDate endDate);

    /**
     * Filter by first name and last name and phone number and brand and model page.
     *
     * @param pageable          the pageable
     * @param firstName         the first name
     * @param lastName          the last name
     * @param clientPhoneNumber the client phone number
     * @param brandName         the brand name
     * @param modelName         the model name
     * @return the page
     */
    Page<RepairOrderDTO> filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModel(Pageable pageable, String firstName,
                                                                                    String lastName, String clientPhoneNumber,
                                                                                    String brandName, String modelName);

    /**
     * Filter by start date page.
     *
     * @param pageable  the pageable
     * @param startDate the start date
     * @param endDate   the end date
     * @return the page
     */
    Page<RepairOrderDTO> filterByStartDate(Pageable pageable, LocalDate startDate, LocalDate endDate);

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
    Page<RepairOrderDTO> filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelAndDate(Pageable pageable, String firstName,
                                                                                           String lastName, String clientPhoneNumber,
                                                                                           String brandName, String modelName,
                                                                                           LocalDate startDate, LocalDate endDate);
}