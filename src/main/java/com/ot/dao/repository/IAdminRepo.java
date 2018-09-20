package com.ot.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ot.dao.entity.Admin;

@Repository
public interface IAdminRepo extends JpaRepository<Admin, Integer> {

}
