package com.tavant.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tavant.dao.UserDao;
import com.tavant.domain.UserDetails;

public class UserDAOImpl implements UserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public boolean addUser(UserDetails userDetails) {
		
		
		return false;
	}

}
