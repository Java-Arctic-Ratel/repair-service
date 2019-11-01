package com.epam.repair.dao;

import com.epam.repair.model.DeviceCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceConditionDao extends JpaRepository <DeviceCondition, Integer> {
}
