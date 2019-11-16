package com.epam.repair.service;

import com.epam.repair.model.RepairOrder;
import com.epam.repair.model.dto.RepairOrderDTO;

import java.util.List;

/**
 * The interface Repair order service.
 */
public interface RepairOrderService {

    /**
     * Repair order find all list.
     *
     * @return the list
     */
    List<RepairOrderDTO> findAll();

    /**
     * Repair order find by id repair order.
     *
     * @param repairOrderId the repair order id
     * @return the repair order
     */
    RepairOrder findById(Integer repairOrderId);

    /**
     * Repair order add repair order.
     *
     * @param repairOrder the repair order
     * @return the repair order
     */
    RepairOrder add(RepairOrder repairOrder);

    /**
     * Repair order update repair order.
     *
     * @param repairOrder the repair order
     * @return the repair order
     */
    RepairOrder update(RepairOrder repairOrder);

    /**
     * Repair order delete.
     *
     * @param repairOrderId the repair order id
     */
    void deleteById(Integer repairOrderId);
}
