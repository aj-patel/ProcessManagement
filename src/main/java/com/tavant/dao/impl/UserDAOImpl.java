package com.tavant.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.tavant.dao.UserDao;
import com.tavant.domain.UserDetails;
import com.tavant.sql.SQLQueries;

public class UserDAOImpl implements UserDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SQLQueries sqlQueries;
	
	public boolean addUser(UserDetails userDetails) {
		
		jdbcTemplate.update(sqlQueries.getAddUserQuery(), new Object[]{userDetails.getUserId(),userDetails.getUserName(),userDetails.getRoleId(),userDetails.getPassword()});
		
		return false;
	}

}
