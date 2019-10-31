package com.epam.repair.dao;

import com.epam.repair.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDao extends JpaRepository <Address, Integer> {
}
