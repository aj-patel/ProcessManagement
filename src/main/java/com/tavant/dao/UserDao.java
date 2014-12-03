package com.tavant.dao;

import com.tavant.domain.UserDetails;
import com.tavant.exception.ResourceNotFoundException;

/**
 * @author connecttoaj
 *This is an interface for User related databse interaction.
 */
public interface UserDao {
	
	public boolean addUser(final UserDetails userDetails) throws ResourceNotFoundException;
	
	public UserDetails getUserDetails(String userName) throws ResourceNotFoundException;

}
