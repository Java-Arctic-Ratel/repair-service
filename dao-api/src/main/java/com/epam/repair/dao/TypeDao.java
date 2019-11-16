package com.epam.repair.dao;

import com.epam.repair.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeDao extends JpaRepository<Type, Integer> {
}
