package com.ot.service;

import org.springframework.stereotype.Service;

import com.ot.dao.entity.Role;

@Service
public interface IRoleService {

	Role getRole(String name);
	void setRole(Role role);
}
