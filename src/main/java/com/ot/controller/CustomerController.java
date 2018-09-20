package com.ot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ot.dao.entity.Customer;
import com.ot.service.ICustomerService;

@RestController("CustCtrl")
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	ICustomerService customerService;
	
	@PreAuthorize("hasRole('Admin')")
	@RequestMapping(value = "", method = RequestMethod.GET, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public List<Customer> getAllCustomers() {
		return customerService.getAll();
	}

}
