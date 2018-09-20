package com.ot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ot.service.IAdminService;

@RestController("AdminCtrl")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	IAdminService adminService;

}
