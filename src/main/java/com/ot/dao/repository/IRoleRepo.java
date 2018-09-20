package com.ot.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ot.dao.entity.Role;

@Repository
public interface IRoleRepo extends JpaRepository<Role, Integer> {
	
	Role findByName(String name);

}
