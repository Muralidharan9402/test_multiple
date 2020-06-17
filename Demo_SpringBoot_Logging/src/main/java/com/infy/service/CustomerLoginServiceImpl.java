package com.infy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dao.CustomerLoginDAO;
import com.infy.model.CustomerLogin;


@Service(value="customerLoginService")
public class CustomerLoginServiceImpl implements CustomerLoginService {

	@Autowired
	private CustomerLoginDAO customerLoginDao;

	public String authenticateCustomer(CustomerLogin customerLogin) throws Exception {
		try{
			String toRet = null;
			CustomerLogin customerLoginFromDao = customerLoginDao
					.getCustomerLoginByLoginName(customerLogin.getLoginName());
			if (customerLogin.getPassword().equals(customerLoginFromDao.getPassword())){
				toRet = "SUCCESS";
			}else{
				throw new Exception("Service.WRONG_CREDENTIALS");
			}
			return toRet;
		}catch(Exception exception){
			Logger logger=LoggerFactory.getLogger(this.getClass());
			logger.error(exception.getMessage(),exception);
			throw exception;
		}
	}
}
