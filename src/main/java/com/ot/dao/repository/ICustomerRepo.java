package com.ot.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ot.dao.entity.Customer;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer, Integer> {

}
