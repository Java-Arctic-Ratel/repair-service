package com.epam.repair.dao;

import com.epam.repair.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetDao extends JpaRepository<Street, Integer> {
}
