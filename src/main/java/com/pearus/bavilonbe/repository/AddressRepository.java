package com.pearus.bavilonbe.repository;

import com.pearus.bavilonbe.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
