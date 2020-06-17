package com.infy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.infy.model.CustomerLogin;
import com.infy.service.CustomerLoginService;

@Controller(value="customerLoginController")
public class CustomerLoginController {

	@Autowired
	private CustomerLoginService customerLoginService;

	public String authenticateCustomer(CustomerLogin customerLogin) throws Exception {
		String b = customerLoginService.authenticateCustomer(customerLogin);
		return b;
	}
}
