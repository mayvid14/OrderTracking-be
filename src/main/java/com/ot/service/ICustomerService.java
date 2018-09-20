package com.ot.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.ot.dao.entity.Customer;
import com.ot.dto.NewUserDto;

@Service
public interface ICustomerService {

	void addNew(NewUserDto newUser);
	List<Customer> getAll();
}
