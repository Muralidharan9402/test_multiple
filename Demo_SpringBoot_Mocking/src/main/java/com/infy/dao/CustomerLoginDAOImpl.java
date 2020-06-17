package com.infy.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.infy.model.CustomerLogin;
@Repository(value="customerLoginDAO")
public class CustomerLoginDAOImpl implements CustomerLoginDAO {
	public CustomerLogin getCustomerLoginByLoginName(String loginName) {
		System.out.println("DAO called");
		Map<String, String> customerCredentials = new HashMap<String, String>();
		customerCredentials.put("tom", "tom123");
		customerCredentials.put("harry", "harry123");
		customerCredentials.put("garry", "garry123");
		customerCredentials.put("monica", "mocica123");
		CustomerLogin customerLogin = new CustomerLogin();
		customerLogin.setLoginName(loginName);
		customerLogin.setPassword(customerCredentials.get(loginName));
		return customerLogin;
	}
}
