package com.ot.service;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ot.dao.entity.Admin;
import com.ot.dao.entity.Role;
import com.ot.dao.repository.IAdminRepo;
import com.ot.dao.repository.IRoleRepo;
import com.ot.dto.NewUserDto;

@Transactional
@Component("AdmSer")
public class AdminServiceImpl implements IAdminService {
	
	@Autowired
	IAdminRepo adminRepo;
	
	@Autowired
	IRoleRepo roleRepo;
	
	@Autowired
	IRoleService roleService;
	
	private Admin newUserToAdminAssembler(NewUserDto newUser, String[] roles) {
		Admin admin = new Admin();
		admin.setFirstName(newUser.getFirstName());
		admin.setJoined(new Date());
		admin.setLastName(newUser.getLastName());
		admin.setPassword(newUser.getPassword());
		admin.setRoles(getSetOfRoles(roles));
		admin.setUsername(newUser.getUsername());
		return admin;
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
		String[] roles = {"Default", "Admin"};
		adminRepo.save(newUserToAdminAssembler(newUser, roles));
	}

}
