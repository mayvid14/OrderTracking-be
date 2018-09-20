package com.ot.service;

import org.springframework.stereotype.Service;

import com.ot.dto.NewUserDto;

@Service
public interface IAdminService {

	void addNew(NewUserDto newUser);
}
