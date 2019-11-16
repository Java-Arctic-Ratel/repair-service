package com.epam.repair.service;

import com.epam.repair.dao.RepairOrderDao;
import com.epam.repair.model.RepairOrder;
import com.epam.repair.model.dto.RepairOrderDTO;
import com.epam.repair.service.mapper.RepairOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Order Service Interface implementation.
 */
@Service
@Transactional
public class RepairOrderServiceImpl implements RepairOrderService {

    private static final String ORDER_NOT_FOUND = "Order not found for this id: ";

    private RepairOrderDao repairOrderDao;

    @Autowired
    private RepairOrderMapper repairOrderMapper;

    public RepairOrderServiceImpl(RepairOrderDao repairOrderDao) {
        this.repairOrderDao = repairOrderDao;
    }

    @Override
    public List<RepairOrderDTO> findAll() {
        List<RepairOrderDTO> repairOrderDTO = repairOrderMapper.repairOrderToOrderDTO(repairOrderDao.findAll());
        return repairOrderDTO;
    }

    @Override
    public RepairOrder findById(Integer orderId) {
        return repairOrderDao.findById(orderId)
                .orElseThrow(() -> new RuntimeException(ORDER_NOT_FOUND + orderId));
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
    public void deleteById(Integer orderId) {
        repairOrderDao.findById(orderId)
                .orElseThrow(() -> new RuntimeException(ORDER_NOT_FOUND + orderId));
        repairOrderDao.deleteById(orderId);
    }
}
