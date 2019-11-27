package com.epam.repair.dao;

import com.epam.repair.model.RepairOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * The interface Repair order dao.
 */
@Repository
public interface RepairOrderDao extends JpaRepository<RepairOrder, Integer> {

    /**
     * Find repair order by client first name containing and client last name containing and client client phone number containing and device brand containing and device model containing all ignore case page.
     *
     * @param pageable          the pageable
     * @param firstName         the first name
     * @param lastName          the last name
     * @param clientPhoneNumber the client phone number
     * @param deviceName        the device name
     * @param Model             the model
     * @return the page
     */
    Page<RepairOrder> findRepairOrderByClient_FirstNameContainingAndClient_LastNameContainingAndClient_clientPhoneNumberContainingAndDevice_BrandContainingAndDevice_ModelContainingAllIgnoreCase(
            Pageable pageable, String firstName, String lastName, String clientPhoneNumber, String deviceName, String Model);

    /**
     * Find by repair order start date between page.
     *
     * @param pageable  the pageable
     * @param startDate the start date
     * @param endDate   the end date
     * @return the page
     */
    Page<RepairOrder> findByRepairOrderStartDateBetween(Pageable pageable, LocalDate startDate, LocalDate endDate);

    /**
     * Find repair order by client first name containing and client last name containing and client client phone number containing and device brand containing and device model containing and repair order start date between all ignore case page.
     *
     * @param pageable          the pageable
     * @param firstName         the first name
     * @param lastName          the last name
     * @param clientPhoneNumber the client phone number
     * @param deviceName        the device name
     * @param Model             the model
     * @param startDate         the start date
     * @param endDate           the end date
     * @return the page
     */
    Page<RepairOrder> findRepairOrderByClient_FirstNameContainingAndClient_LastNameContainingAndClient_clientPhoneNumberContainingAndDevice_BrandContainingAndDevice_ModelContainingAndRepairOrderStartDateBetweenAllIgnoreCase(
            Pageable pageable, String firstName, String lastName, String clientPhoneNumber, String deviceName, String Model, LocalDate startDate, LocalDate endDate);

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
    @Query("SELECT r from RepairOrder r where (?1 is null or lower(r.client.firstName) LIKE lower(concat('%', ?1,'%'))) " +
            "AND (?2 is null or lower(r.client.lastName) LIKE (lower(concat('%', ?2,'%'))))" +
            "AND (?3 is null or lower(r.client.clientPhoneNumber) LIKE lower(concat('%', ?3,'%')))  " +
            "AND (?4 is null or lower(r.device.brand.brandName) LIKE lower(concat('%', ?4,'%'))) " +
            "AND (?5 is null or lower(r.device.model.modelName) LIKE lower(concat('%', ?5,'%'))) " +
            "order by r.repairOrderId")
    Page<RepairOrder> filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelJPQL(Pageable pageable, String firstName,
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
    @Query("SELECT r from RepairOrder r where (?1 is null or ?2 is null or (?1 is null and ?2 is null) or r.repairOrderStartDate between ?1 and ?2)")
    Page<RepairOrder> filterByStartDateJPQL(Pageable pageable, LocalDate startDate, LocalDate endDate);

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
    @Query("SELECT r from RepairOrder r where (?1 is null or lower(r.client.firstName) LIKE lower(concat('%', ?1,'%'))) " +
            "AND (?2 is null or lower(r.client.lastName) LIKE (lower(concat('%', ?2,'%'))))" +
            "AND (?3 is null or lower(r.client.clientPhoneNumber) LIKE lower(concat('%', ?3,'%')))  " +
            "AND (?4 is null or lower(r.device.brand.brandName) LIKE lower(concat('%', ?4,'%'))) " +
            "AND (?5 is null or lower(r.device.model.modelName) LIKE lower(concat('%', ?5,'%'))) " +
            "AND (?6 is null or ?7 is null or (?6 is null and ?7 is null) or r.repairOrderStartDate between ?6 and ?7) " +
            "order by r.repairOrderId")
    Page<RepairOrder> filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelAndDateJPQL(Pageable pageable, String firstName,
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
    @Query(value = "SELECT * from repair_order r\n" +
            "         LEFT JOIN client c on r.client_id = c.client_id\n" +
            "         LEFT JOIN device d on r.device_id = d.device_id\n" +
            "         LEFT JOIN model m on d.model_id = m.model_id\n" +
            "         LEFT JOIN brand b on d.brand_id = b.brand_id\n" +
            "where lower(c.client_first_name) LIKE lower(concat('%', ?1,'%'))\n" +
            "  AND lower(c.client_last_name) LIKE lower(concat('%', ?2,'%'))\n" +
            "  AND lower(c.client_phone_number) LIKE lower(concat('%', ?3,'%'))\n" +
            "  AND lower(b.brand_name) LIKE lower(concat('%', ?4,'%'))" +
            "  AND lower(m.model_name) LIKE lower(concat('%', ?5,'%'))\n" +
            "order by r.repair_order_id",
            nativeQuery = true)
    Page<RepairOrder> filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModel(Pageable pageable, String firstName,
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
    @Query(value = "SELECT * from repair_order r where (?1 is null or ?2 is null or (?1 is null and ?2 is null) or " +
            "r.repair_order_start_date between ?1 and ?2) order by r.repair_order_id",
            nativeQuery = true)
    Page<RepairOrder> filterByStartDate(Pageable pageable, LocalDate startDate, LocalDate endDate);

    /**
     * Filter by first name and last name and phone number and brand and model and date page.
     *
     * @param pageable          the pageable
     * @param firstName         the first name
     * @param lastName          the last name
     * @param clientPhoneNumber the client phone number
     * @param brandName         the brand name
     * @param modelName         the model name
     * @param starDate          the star date
     * @param endDate           the end date
     * @return the page
     */
    @Query(value = "SELECT * from repair_order r\n" +
            "         LEFT JOIN client c on r.client_id = c.client_id\n" +
            "         LEFT JOIN device d on r.device_id = d.device_id\n" +
            "         LEFT JOIN model m on d.model_id = m.model_id\n" +
            "         LEFT JOIN brand b on d.brand_id = b.brand_id\n" +
            "where lower(c.client_first_name) LIKE lower(concat('%', ?1,'%'))\n" +
            "  AND lower(c.client_last_name) LIKE lower(concat('%', ?2,'%'))\n" +
            "  AND lower(c.client_phone_number) LIKE lower(concat('%', ?3,'%'))\n" +
            "  AND lower(b.brand_name) LIKE lower(concat('%', ?4,'%'))" +
            "  AND lower(m.model_name) LIKE lower(concat('%', ?5,'%'))\n" +
            "  AND (?6 is null or ?7 is null or (?6 is null and ?7 is null) or r.repair_order_start_date between ?6 and ?7) " +
            "order by r.repair_order_id",
            nativeQuery = true)
    Page<RepairOrder> filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelAndDate(Pageable pageable, String firstName,
                                                                                        String lastName, String clientPhoneNumber,
                                                                                        String brandName, String modelName,
                                                                                        LocalDate starDate, LocalDate endDate);
}