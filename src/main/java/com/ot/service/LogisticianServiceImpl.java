package com.ot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ot.dao.entity.Logistician;
import com.ot.dao.entity.Role;
import com.ot.dao.repository.ILogisticianRepo;
import com.ot.dao.repository.IRoleRepo;
import com.ot.dto.NewUserDto;

@Transactional
@Component("LogSer")
public class LogisticianServiceImpl implements ILogisticianService {
	
	@Autowired
	ILogisticianRepo logRepo;
	
	@Autowired
	IRoleRepo roleRepo;
	
	@Autowired
	IRoleService roleService;
	
	private Logistician newUserToLogisticianAssembler(NewUserDto newUser, String[] roles) {
		Logistician log = new Logistician();
		log.setAddresses(new ArrayList<>());
		log.setCompany("");
		log.setFirstName(newUser.getFirstName());
		log.setJoined(new Date());
		log.setLastName(newUser.getLastName());
		log.setPassword(newUser.getPassword());
		log.setRoles(getSetOfRoles(roles));
		log.setTasks(new HashSet<>());
		log.setUsername(newUser.getUsername());
		return log;
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
		String[] roles = {"Default", "Logistician"};
		logRepo.save(newUserToLogisticianAssembler(newUser, roles));
	}

}
