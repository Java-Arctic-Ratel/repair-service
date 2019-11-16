package com.epam.repair.dao;

import com.epam.repair.model.RepairOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairOrderDao extends JpaRepository<RepairOrder, Integer> {
}
