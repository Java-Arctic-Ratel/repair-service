package com.epam.repair.dao;

import com.epam.repair.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelDao extends JpaRepository <Model, Integer> {
}
