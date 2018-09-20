package com.ot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ot.dao.entity.Role;
import com.ot.dao.repository.IRoleRepo;

@Transactional
@Component("RoleSer")
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	IRoleRepo roleRepo;

	@Override
	public Role getRole(String name) {
		return roleRepo.findByName(name);
	}

	@Override
	public void setRole(Role role) {
		roleRepo.save(role);
	}

}
