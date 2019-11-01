package com.epam.repair.dao;

import com.epam.repair.model.Patronymic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatronymicDao extends JpaRepository <Patronymic, Integer> {
}
