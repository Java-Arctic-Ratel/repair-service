package com.epam.repair.dao;

import com.epam.repair.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandDao extends JpaRepository <Brand, Integer> {
}
