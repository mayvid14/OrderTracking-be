package com.ot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.ot.dao.repository.IUserRepo;

@Transactional
@Controller("UserSer")
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepo userRepo;
}
