package com.epam.repair.dao;

import com.epam.repair.model.Executor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecutorDao extends JpaRepository <Executor, Integer> {
}
