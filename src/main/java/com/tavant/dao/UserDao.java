package com.tavant.dao;

import com.tavant.domain.UserDetails;

/**
 * @author connecttoaj
 *This is an interface for User related databse interaction.
 */
public interface UserDao {
	
	public boolean addUser(final UserDetails userDetails);
	
	public UserDetails getUserDetails(String userName);

}
