package com.ot.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ot.dao.entity.Logistician;

@Repository
public interface ILogisticianRepo extends JpaRepository<Logistician, Integer> {

}
