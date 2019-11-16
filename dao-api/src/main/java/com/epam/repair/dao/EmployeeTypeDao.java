package com.epam.repair.dao;

import com.epam.repair.model.EmployeeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeTypeDao extends JpaRepository<EmployeeType, Integer> {
}
