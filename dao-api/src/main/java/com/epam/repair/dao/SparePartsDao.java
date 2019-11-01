package com.epam.repair.dao;

import com.epam.repair.model.SpareParts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SparePartsDao extends JpaRepository <SpareParts, Integer> {
}
