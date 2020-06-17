package com.infy.service;

import com.infy.model.CustomerLogin;

public interface CustomerLoginService {
	public String authenticateCustomer(CustomerLogin customerLogin)
			throws Exception;
}
