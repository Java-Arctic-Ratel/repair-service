package com.epam.repair.dao;

import com.epam.repair.model.Complectation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplectationDao extends JpaRepository <Complectation, Integer> {
}
