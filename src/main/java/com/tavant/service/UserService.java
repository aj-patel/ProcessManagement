package com.tavant.service;

import com.tavant.domain.UserDetails;

public interface UserService {
	
	public void addUserSerive(final UserDetails userDetails);
	
	public UserDetails validateUserLogin(String userName, String password);
	

}
