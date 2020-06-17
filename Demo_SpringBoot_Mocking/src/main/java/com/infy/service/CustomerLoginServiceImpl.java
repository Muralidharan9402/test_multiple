package com.infy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dao.CustomerLoginDAO;
import com.infy.model.CustomerLogin;
@Service(value="customerLoginService")
public class CustomerLoginServiceImpl implements CustomerLoginService {

	@Autowired
	private CustomerLoginDAO customerLoginDao;

	public String authenticateCustomer(CustomerLogin customerLogin) throws Exception {
		String toRet = null;
		CustomerLogin customerLoginFromDao = customerLoginDao
				.getCustomerLoginByLoginName(customerLogin.getLoginName());
		if (customerLogin.getPassword().equals(customerLoginFromDao.getPassword())){
			toRet = "SUCCESS";
		}else{
			throw new Exception("Service.WRONG_CREDENTIALS");
		}
		return toRet;
	}
}
