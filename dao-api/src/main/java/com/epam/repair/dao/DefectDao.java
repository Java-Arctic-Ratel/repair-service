package com.epam.repair.dao;

import com.epam.repair.model.Defect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DefectDao extends JpaRepository <Defect, Integer> {
}
