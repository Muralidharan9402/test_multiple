package com.infy;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.*;
import com.infy.dao.CustomerLoginDAO;
import com.infy.model.CustomerLogin;
import com.infy.service.CustomerLoginService;
import com.infy.service.CustomerLoginServiceImpl;

@RunWith(SpringRunner.class)
public class DemoSpringBootTestingApplicationTests {
	@Mock
	CustomerLoginDAO customerLoginDao;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@InjectMocks
	CustomerLoginService customerLoginService = new CustomerLoginServiceImpl();

	@Test
	public void authenticateCustomerLoginValidCredentials() throws Exception {
		CustomerLogin c = new CustomerLogin();
		c.setLoginName("tom");
		c.setPassword("tom123");
		when(customerLoginDao.getCustomerLoginByLoginName("tom")).thenReturn(c);
		String actual = customerLoginService.authenticateCustomer(c);
		Assert.assertEquals("SUCCESS", actual);
	}

	@Test
	public void authenticateCustomerTestInValidCredentials() throws Exception {
		expectedException.expect(Exception.class);
		expectedException.expectMessage("Service.WRONG_CREDENTIALS");
		CustomerLogin fromDao = new CustomerLogin();
		fromDao.setLoginName("tom");
		fromDao.setPassword("tom123");
		when(customerLoginDao.getCustomerLoginByLoginName("tom")).thenReturn(
				fromDao);
		CustomerLogin toSer = new CustomerLogin();
		toSer.setLoginName("tom");
		toSer.setPassword("tom12");

		customerLoginService.authenticateCustomer(toSer);

	}
}
