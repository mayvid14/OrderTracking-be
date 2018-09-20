package com.ot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ot.config.TokenProvider;
import com.ot.config.model.AuthToken;
import com.ot.dto.LoginDto;
import com.ot.dto.NewUserDto;
import com.ot.service.IAdminService;
import com.ot.service.ICustomerService;
import com.ot.service.ILogisticianService;
import com.ot.service.IMerchantService;
import com.ot.service.IUserService;

@RestController("UserCtrl")
@CrossOrigin
public class UserController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenProvider jwtTokenUtil;

	@Autowired
	private IUserService userService;

	@Autowired
	private IAdminService adminService;

	@Autowired
	private ICustomerService custService;

	@Autowired
	private IMerchantService merchantService;

	@Autowired
	private ILogisticianService logService;

	@Autowired
	private BCryptPasswordEncoder crypt;

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	// @PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDto data) throws AuthenticationException {
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		final String token = jwtTokenUtil.generateToken(authentication);
		return ResponseEntity.ok(new AuthToken(token));
//		return "True";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public boolean signup(@RequestBody NewUserDto newUser) {
		newUser.setPassword(crypt.encode(newUser.getPassword()));
		String type = newUser.getRole().getName().toLowerCase();
		boolean done = false;
		if (type.equals("customer")) {
			custService.addNew(newUser);
			done = !done;
		} else if (type.equals("merchant")) {
			merchantService.addNew(newUser);
			done = !done;
		} else if (type.equals("logistician")) {
			logService.addNew(newUser);
			done = !done;
		} else if (type.equals("admin")) {
			adminService.addNew(newUser);
			done = !done;
		}
		return done;
	}

}
