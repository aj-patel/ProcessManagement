package com.tavant.service;

import com.tavant.domain.UserDetails;
import com.tavant.exception.ResourceNotFoundException;

public interface UserService {
	
	public boolean addUserSerive(final UserDetails userDetails) throws ResourceNotFoundException;
	
	public UserDetails validateUserLogin(String userName, String password) throws ResourceNotFoundException;
	

}
