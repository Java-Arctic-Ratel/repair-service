package com.epam.repair.service;

import com.epam.repair.dao.RepairOrderDao;
import com.epam.repair.exception.OrderNotFoundException;
import com.epam.repair.model.RepairOrder;
import com.epam.repair.model.dto.RepairOrderDTO;
import com.epam.repair.service.mapper.RepairOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

/**
 * Order Service Interface implementation.
 */
@Service
@Transactional
public class RepairOrderServiceImpl implements RepairOrderService {

    private RepairOrderDao repairOrderDao;

    @Autowired
    private RepairOrderMapper repairOrderMapper;

    /**
     * Instantiates a new Repair order service.
     *
     * @param repairOrderDao the repair order dao
     */
    public RepairOrderServiceImpl(RepairOrderDao repairOrderDao) {
        this.repairOrderDao = repairOrderDao;
    }

    @Override
    public Page<RepairOrderDTO> findAll(Pageable pageable) {
        Page<RepairOrder> repairOrders = repairOrderDao.findAll(pageable);
        return repairOrders.map(repairOrder -> repairOrderMapper.repairOrderToOrderDTO(repairOrder));
    }

    @Override
    public RepairOrder findById(Integer repairOrderId) {
        return repairOrderDao.findById(repairOrderId)
                .orElseThrow(() -> new OrderNotFoundException(repairOrderId));
    }

    @Override
    public RepairOrder add(RepairOrder repairOrder) {
        return repairOrderDao.save(repairOrder);
    }

    @Override
    public RepairOrder update(RepairOrder repairOrder) {
        return repairOrderDao.save(repairOrder);
    }

    @Override
    public void deleteById(Integer repairOrderId) {
        try {
            repairOrderDao.deleteById(repairOrderId);
        } catch (EmptyResultDataAccessException e) {
            throw new OrderNotFoundException(repairOrderId);
        }
    }

    @Override
    public Page<RepairOrderDTO> findRepairOrderByClient_FirstNameContainingAndClient_LastNameContainingAndClient_clientPhoneNumberContainingAndDevice_BrandContainingAndDevice_ModelContainingAllIgnoreCase(Pageable pageable,
                                                                                                                                                                                                            String firstName,
                                                                                                                                                                                                            String lastName,
                                                                                                                                                                                                            String clientPhoneNumber,
                                                                                                                                                                                                            String brandName,
                                                                                                                                                                                                            String modelName) {
        Page<RepairOrder> repairOrders = repairOrderDao.
                findRepairOrderByClient_FirstNameContainingAndClient_LastNameContainingAndClient_clientPhoneNumberContainingAndDevice_BrandContainingAndDevice_ModelContainingAllIgnoreCase(pageable, firstName, lastName, clientPhoneNumber, brandName, modelName);
        return repairOrders.map(repairOrder -> repairOrderMapper.repairOrderToOrderDTO(repairOrder));
    }

    @Override
    public Page<RepairOrderDTO> findByRepairOrderStartDateBetween(Pageable pageable, LocalDate startDate, LocalDate endDate) {
        Page<RepairOrder> repairOrders = repairOrderDao.
                findByRepairOrderStartDateBetween(pageable, startDate, endDate);
        return repairOrders.map(repairOrder -> repairOrderMapper.repairOrderToOrderDTO(repairOrder));
    }

    @Override
    public Page<RepairOrderDTO> findRepairOrderByClient_FirstNameContainingAndClient_LastNameContainingAndClient_clientPhoneNumberContainingAndDevice_BrandContainingAndDevice_ModelContainingAndRepairOrderStartDateBetweenAllIgnoreCase(Pageable pageable,
                                                                                                                                                                                                                                          String firstName,
                                                                                                                                                                                                                                          String lastName,
                                                                                                                                                                                                                                          String clientPhoneNumber,
                                                                                                                                                                                                                                          String brandName,
                                                                                                                                                                                                                                          String modelName,
                                                                                                                                                                                                                                          LocalDate startDate,
                                                                                                                                                                                                                                          LocalDate endDate) {
        Page<RepairOrder> repairOrders = repairOrderDao.
                findRepairOrderByClient_FirstNameContainingAndClient_LastNameContainingAndClient_clientPhoneNumberContainingAndDevice_BrandContainingAndDevice_ModelContainingAndRepairOrderStartDateBetweenAllIgnoreCase(
                        pageable, firstName, lastName, clientPhoneNumber, brandName, modelName, startDate, endDate);
        return repairOrders.map(repairOrder -> repairOrderMapper.repairOrderToOrderDTO(repairOrder));
    }

    @Override
    public Page<RepairOrderDTO> filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelJPQL(Pageable pageable, String firstName,
                                                                                               String lastName, String clientPhoneNumber,
                                                                                               String brandName, String modelName) {
        Page<RepairOrder> repairOrders = repairOrderDao.filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelJPQL(pageable,
                firstName, lastName, clientPhoneNumber, brandName, modelName);
        return repairOrders.map(repairOrder -> repairOrderMapper.repairOrderToOrderDTO(repairOrder));
    }

    @Override
    public Page<RepairOrderDTO> filterByStartDateJPQL(Pageable pageable, LocalDate startDate, LocalDate endDate) {
        Page<RepairOrder> repairOrders = repairOrderDao.filterByStartDateJPQL(pageable, startDate, endDate);
        return repairOrders.map(repairOrder -> repairOrderMapper.repairOrderToOrderDTO(repairOrder));
    }

    @Override
    public Page<RepairOrderDTO> filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelAndDateJPQL(Pageable pageable, String firstName,
                                                                                                      String lastName, String clientPhoneNumber,
                                                                                                      String brandName, String modelName,
                                                                                                      LocalDate startDate, LocalDate endDate) {
        Page<RepairOrder> repairOrders = repairOrderDao.filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelAndDateJPQL(pageable,
                firstName, lastName, clientPhoneNumber, brandName, modelName, startDate, endDate);
        return repairOrders.map(repairOrder -> repairOrderMapper.repairOrderToOrderDTO(repairOrder));
    }

    @Override
    public Page<RepairOrderDTO> filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModel(Pageable pageable, String firstName,
                                                                                           String lastName, String clientPhoneNumber,
                                                                                           String brandName, String modelName) {
        Page<RepairOrder> repairOrders = repairOrderDao.filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModel(pageable,
                firstName, lastName, clientPhoneNumber, brandName, modelName);
        return repairOrders.map(repairOrder -> repairOrderMapper.repairOrderToOrderDTO(repairOrder));
    }

    @Override
    public Page<RepairOrderDTO> filterByStartDate(Pageable pageable, LocalDate startDate, LocalDate endDate) {
        Page<RepairOrder> repairOrders = repairOrderDao.filterByStartDate(pageable, startDate, endDate);
        return repairOrders.map(repairOrder -> repairOrderMapper.repairOrderToOrderDTO(repairOrder));
    }

    @Override
    public Page<RepairOrderDTO> filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelAndDate(Pageable pageable, String firstName,
                                                                                                  String lastName, String clientPhoneNumber,
                                                                                                  String brandName, String modelName,
                                                                                                  LocalDate startDate, LocalDate endDate) {
        Page<RepairOrder> repairOrders = repairOrderDao.filterByFirstNameAndLastNameAndPhoneNumberAndBrandAndModelAndDate(pageable,
                firstName, lastName, clientPhoneNumber, brandName, modelName, startDate, endDate);
        return repairOrders.map(repairOrder -> repairOrderMapper.repairOrderToOrderDTO(repairOrder));
    }

    @Override
    public void deleteAll() {
        repairOrderDao.deleteAll();
    }
}
