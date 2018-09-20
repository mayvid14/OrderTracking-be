package com.ot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ot.service.IMerchantService;

@RestController("MerCtrl")
@RequestMapping("/merchant")
public class MerchantController {
	
	@Autowired
	IMerchantService merchantService;

}
