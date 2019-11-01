package com.epam.repair.dao;

import com.epam.repair.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersDao extends JpaRepository <Orders, Integer> {
}
