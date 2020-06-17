package com.infy.dao;

import com.infy.model.CustomerLogin;

public interface CustomerLoginDAO {
	public CustomerLogin getCustomerLoginByLoginName(String loginName);
}
