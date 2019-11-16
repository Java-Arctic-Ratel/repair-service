package com.epam.repair.dao;

import com.epam.repair.model.SparePart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SparePartDao extends JpaRepository<SparePart, Integer> {
}
