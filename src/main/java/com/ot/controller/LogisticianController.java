package com.ot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ot.service.ILogisticianService;

@RestController("LogCtrl")
@RequestMapping("/logistician")
public class LogisticianController {

	@Autowired
	ILogisticianService logService;
}
