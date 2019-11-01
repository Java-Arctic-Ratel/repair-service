package com.epam.repair.dao;

import com.epam.repair.model.LastName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LastNameDao extends JpaRepository <LastName, Integer> {
}
