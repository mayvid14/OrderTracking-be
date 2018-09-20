package com.ot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ot.dao.entity.Customer;
import com.ot.dao.entity.Role;
import com.ot.dao.repository.ICustomerRepo;
import com.ot.dao.repository.IRoleRepo;
import com.ot.dto.NewUserDto;

@Transactional
@Component("CustSer")
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	ICustomerRepo custRepo;
	
	@Autowired
	IRoleRepo roleRepo;
	
	@Autowired
	IRoleService roleService;
	
	private Customer newUserToCustomerAssembler(NewUserDto newUser, String[] roles) {
		Customer customer = new Customer();
		customer.setAddresses(new ArrayList<>());
		customer.setFirstName(newUser.getFirstName());
		customer.setJoined(new Date());
		customer.setLastName(newUser.getLastName());
		customer.setOrders(new ArrayList<>());
		customer.setPassword(newUser.getPassword());
		customer.setRoles(getSetOfRoles(roles));
		customer.setUsername(newUser.getUsername());
		return customer;
	}
	
	private Set<Role> getSetOfRoles(String[] roles) {
		Set<Role> set = new HashSet<>();
		for(String roleStr: roles) {
			Role role = roleService.getRole(roleStr);
			if(role == null) {
				role = new Role();
				role.setName(roleStr);
				roleRepo.save(role);
			}
			set.add(role);
		}
		return set;
	}
	
	@Override
	public void addNew(NewUserDto newUser) {
		String[] roles = {"Default", "Customer"};
		custRepo.save(newUserToCustomerAssembler(newUser, roles));
	}

	@Override
	public List<Customer> getAll() {
		return custRepo.findAll();
	}

}
