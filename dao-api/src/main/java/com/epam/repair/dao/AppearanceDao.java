package com.epam.repair.dao;

import com.epam.repair.model.Appearance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppearanceDao extends JpaRepository <Appearance, Integer> {
}
