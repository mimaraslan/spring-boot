package com.mimaraslan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mimaraslan.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}