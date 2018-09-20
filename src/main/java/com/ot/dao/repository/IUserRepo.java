package com.ot.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ot.dao.entity.User;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {

	User findByUsername(String email);
}
