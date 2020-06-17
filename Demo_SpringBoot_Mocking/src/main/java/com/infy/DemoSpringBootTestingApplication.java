package com.infy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.infy.controller.CustomerLoginController;
import com.infy.model.CustomerLogin;

@SpringBootApplication
public class DemoSpringBootTestingApplication implements CommandLineRunner {

	@Autowired
	CustomerLoginController customerLoginController;
	@Autowired
	Environment environment;
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootTestingApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		try{

			CustomerLogin customerLogin = new CustomerLogin();
			customerLogin.setLoginName("tom");
			customerLogin.setPassword("tom123");

			customerLoginController.authenticateCustomer(customerLogin);
			System.out.println(environment.getProperty("SUCCESS"));
		}catch(Exception exception){
			System.out.println(environment.getProperty(exception.getMessage()));
		}
		
	}

}

