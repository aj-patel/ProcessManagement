package com.tavant.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.tavant.dao.UserDao;
import com.tavant.domain.UserDetails;
import com.tavant.service.UserService;

public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public void addUserSerive(final UserDetails userDetails) {

		userDao.addUser(userDetails);
		
	}
	
	public boolean validateUserLogin(String userName, String password) {
		boolean isValid = false;
		UserDetails userDetails = userDao.getUserDetails(userName, password);
		if(null != userDetails.getUserId()) {
			isValid = true;
		}
		return isValid;
	}
}
