package com.ot.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ot.dao.entity.Merchant;

@Repository
public interface IMerchantRepo extends JpaRepository<Merchant, Integer> {

}
