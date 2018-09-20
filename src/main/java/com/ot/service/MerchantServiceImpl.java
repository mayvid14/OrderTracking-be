package com.ot.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ot.dao.entity.Merchant;
import com.ot.dao.entity.Role;
import com.ot.dao.repository.IMerchantRepo;
import com.ot.dao.repository.IRoleRepo;
import com.ot.dto.NewUserDto;

@Transactional
@Component("MerSer")
public class MerchantServiceImpl implements IMerchantService {
	
	@Autowired
	IMerchantRepo merchantRepo;
	
	@Autowired
	IRoleRepo roleRepo;

	@Autowired
	IRoleService roleService;
	
	private Merchant newUserToMerchantAssembler(NewUserDto newUser, String[] roles) {
		Merchant merchant = new Merchant();
		merchant.setAddresses(new ArrayList<>());
		merchant.setFeeds(new HashSet<>());
		merchant.setFirstName(newUser.getFirstName());
		merchant.setJoined(new Date());
		merchant.setLastName(newUser.getLastName());
		merchant.setOrders(new ArrayList<>());
		merchant.setPassword(newUser.getPassword());
		merchant.setRoles(getSetOfRoles(roles));
		merchant.setUsername(newUser.getUsername());
		return merchant;
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
		String[] roles = {"Default", "Merchant"};
		merchantRepo.save(newUserToMerchantAssembler(newUser, roles));
	}
}
