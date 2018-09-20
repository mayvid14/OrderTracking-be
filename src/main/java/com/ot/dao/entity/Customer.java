package com.ot.dao.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ot_customer")
public class Customer extends User {
	
	@OneToMany
	private List<Address> addresses;
	
	@OneToMany
	private List<Order> orders;

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

}
