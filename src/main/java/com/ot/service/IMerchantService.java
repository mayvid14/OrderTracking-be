package com.ot.service;

import org.springframework.stereotype.Service;

import com.ot.dto.NewUserDto;

@Service
public interface IMerchantService {

	void addNew(NewUserDto newUser);
}
